package com.kospavel.androidtest.ui.mainfeed.mainfeedrepository.api

import com.kospavel.androidtest.ui.mainfeed.mainfeedrepository.api.model.MainFeedResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface MainFeedApi {

    @GET("/best/.json")
    fun best(): Observable<MainFeedResponse>

}