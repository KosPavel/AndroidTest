package com.kospavel.androidtest.ui.mainfeed.mainfeedrepository.api

import com.kospavel.androidtest.ui.mainfeed.mainfeedrepository.api.model.MainFeedResponse
import com.kospavel.androidtest.ui.mainfeed.mainfeedrepository.api.model.SubredditInfoResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface MainFeedApi {

    @GET("/best/.json")
    fun best(): Observable<MainFeedResponse>

    @GET("r/{subreddit}/about.json")
    fun subredditInfo(@Path("subreddit") subreddit: String): Observable<SubredditInfoResponse>
}