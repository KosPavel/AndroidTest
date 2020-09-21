package com.kospavel.androidtest.ui.mainfeed.mainfeedrepository

import com.google.gson.GsonBuilder
import com.kospavel.androidtest.ui.mainfeed.RawPostData
import com.kospavel.androidtest.ui.mainfeed.mainfeedrepository.api.MainFeedApi
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainFeedRepositoryImpl : MainFeedRepository {

    private val mainFeedApi = Retrofit.Builder().baseUrl("https://www.reddit.com/")
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().create()
            )
        )
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build().create<MainFeedApi>()

    override fun getFeed(): Observable<MainFeedResponseStatus> {
        return mainFeedApi.best()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .map<MainFeedResponseStatus> {
                val list = mutableListOf<RawPostData>()
                for (children in it.data.children) {
                    list.add(
                        RawPostData(
                            author = children.data.author,
                            title = children.data.title,
                            url = children.data.url
                        )
                    )
                }
                MainFeedResponseStatus.Ok(list)
            }
            .onErrorReturn {
                MainFeedResponseStatus.Error(it)
            }
    }
}