package com.kospavel.androidtest.ui.mainfeed.mainfeedrepository

import com.kospavel.androidtest.ui.mainfeed.RawPostData
import io.reactivex.rxjava3.core.Observable

interface MainFeedRepository {

    fun getFeed() : Observable<MainFeedResponseStatus>

}

sealed class MainFeedResponseStatus {
    class Ok(val rawPostData: List<RawPostData>) : MainFeedResponseStatus()
    class Error(val e: Throwable) : MainFeedResponseStatus()
}