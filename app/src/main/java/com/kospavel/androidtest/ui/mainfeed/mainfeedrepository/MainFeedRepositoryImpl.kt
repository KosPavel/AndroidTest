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
            .flatMap {
                val items = mutableListOf<RawPostData>()
                for (children in it.data.children) {
                    getSubredditInfo(children.data.subreddit).observeOn(Schedulers.computation())
                        .map { subreddit ->
                            items.add(
                                RawPostData(
                                    author = children.data.author,
                                    title = children.data.title,
                                    url = children.data.url,
                                    subreddit = subreddit
                                )
                            )
                        }
                }
                Observable.just(items) //TODO айтемс улетают до заполнения
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
                    it.data.name,
                    it.data.icon_img
                )
            }
    }
}