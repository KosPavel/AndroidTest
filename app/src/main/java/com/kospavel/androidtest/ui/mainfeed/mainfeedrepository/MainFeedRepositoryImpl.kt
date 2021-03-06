package com.kospavel.androidtest.ui.mainfeed.mainfeedrepository

import com.google.gson.GsonBuilder
import com.kospavel.androidtest.ui.mainfeed.RawPostData
import com.kospavel.androidtest.ui.mainfeed.Subreddit
import com.kospavel.androidtest.ui.mainfeed.mainfeedrepository.api.MainFeedApi
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainFeedRepositoryImpl : MainFeedRepository {

    private val loggingInterceptor = HttpLoggingInterceptor()
    private val client = OkHttpClient().newBuilder()
        .addInterceptor(loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)).build()

    private val mainFeedApi = Retrofit.Builder().baseUrl("https://www.reddit.com/")
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().create()
            )
        )
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(client)
        .build()
        .create<MainFeedApi>()

    override fun getFeed(): Observable<MainFeedResponseStatus> {
        return mainFeedApi.best()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .flatMap { mainResponse ->
                val subreddits: List<Observable<Subreddit>> = mainResponse.data.children.map {
                    getSubredditInfo(it.data.subreddit)
                }
                Observable.combineLatest<Subreddit, List<RawPostData>>(subreddits) { array ->
                    val items = mutableListOf<RawPostData>()
                    array.map { it as Subreddit }.forEachIndexed { index, item ->
                        items.add(
                            RawPostData(
                                author = mainResponse.data.children[index].data.author,
                                title = mainResponse.data.children[index].data.title,
                                url = mainResponse.data.children[index].data.url,
                                subreddit = item
                            )
                        )
                    }
                    items
                }
            }
            .map<MainFeedResponseStatus> {
                MainFeedResponseStatus.Ok(it)
            }
            .onErrorReturn {
                MainFeedResponseStatus.Error(it)
            }
    }

    private fun getSubredditInfo(subreddit: String): Observable<Subreddit> {
        return mainFeedApi.subredditInfo(subreddit)
            .subscribeOn(Schedulers.io())
            .map<Subreddit> {
                Subreddit(
                    subreddit,
                    it.data.icon_img
                )
            }
    }
}