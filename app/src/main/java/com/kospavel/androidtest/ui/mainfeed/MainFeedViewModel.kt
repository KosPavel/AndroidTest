package com.kospavel.androidtest.ui.mainfeed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kospavel.androidtest.ui.mainfeed.mainfeedrepository.MainFeedRepositoryImpl
import com.kospavel.androidtest.ui.mainfeed.mainfeedrepository.MainFeedResponseStatus
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class MainFeedViewModel : ViewModel() {

    private val mainFeedRepository = MainFeedRepositoryImpl()
    private val _uiStructure = MutableLiveData<List<Any>>(emptyList())
    val uiStructure: LiveData<List<Any>> = _uiStructure

    fun fetchMainFeed() {
        mainFeedRepository.getFeed()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                when (it) {
                    is MainFeedResponseStatus.Ok -> {
                        _uiStructure.value = it.posts
                    }
                    is MainFeedResponseStatus.Error -> {
                        _uiStructure.value = emptyList()
                    }
                }
            }
    }
}