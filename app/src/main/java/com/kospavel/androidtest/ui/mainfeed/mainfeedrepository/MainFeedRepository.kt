package com.kospavel.androidtest.ui.mainfeed.mainfeedrepository

import com.kospavel.androidtest.ui.mainfeed.Post
import io.reactivex.rxjava3.core.Observable

interface MainFeedRepository {

    fun getFeed() : Observable<MainFeedResponseStatus>

}

sealed class MainFeedResponseStatus {
    class Ok(val posts: List<Post>) : MainFeedResponseStatus()
    class Error(val e: Throwable) : MainFeedResponseStatus()
}