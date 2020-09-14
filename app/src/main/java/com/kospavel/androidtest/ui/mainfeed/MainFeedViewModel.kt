package com.kospavel.androidtest.ui.mainfeed

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.GsonBuilder
import com.kospavel.androidtest.ui.mainfeed.mainfeedrepository.api.MainFeedApi
import com.kospavel.androidtest.ui.mainfeed.mainfeedrepository.api.model.MainFeedResponse
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainFeedViewModel : ViewModel() {

    private val mainFeedApi = Retrofit.Builder().baseUrl("https://www.reddit.com/")
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().setLenient().create()
            )
        )
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build().create<MainFeedApi>()

    fun best(): Observable<MainFeedResponse> {
        return mainFeedApi.best().subscribeOn(Schedulers.io()).doOnError {
            Log.i("qwerty", it.toString())
        }
    }

}