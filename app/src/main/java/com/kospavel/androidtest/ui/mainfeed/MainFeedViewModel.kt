package com.kospavel.androidtest.ui.mainfeed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kospavel.androidtest.ui.mainfeed.mainfeedrepository.MainFeedRepositoryImpl
import com.kospavel.androidtest.ui.mainfeed.mainfeedrepository.MainFeedResponseStatus
import com.kospavel.androidtest.ui.mainfeed.mainfeedrepository.PostBuilder
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainFeedViewModel : ViewModel() {

    private val mainFeedRepository = MainFeedRepositoryImpl()
    private val _uiStructure = MutableLiveData<List<Any>>(emptyList())
    val uiStructure: LiveData<List<Any>> = _uiStructure

    fun fetchMainFeed() {
        mainFeedRepository.getFeed()
            .observeOn(Schedulers.computation())
            .map {
                val structure = when (it) {
                    is MainFeedResponseStatus.Ok -> {
                        val items = mutableListOf<Any>()
                        for (el in it.rawPostData) {
                            items.add(PostBuilder.build(el))
                        }
                        items
                    }
                    is MainFeedResponseStatus.Error -> {
                        listOf(NoPosts())
                    }
                }
                structure
            }
            .onErrorReturn {
                listOf(NoPosts()) //TODO proper error handling
            }
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                _uiStructure.value = it
            }
            .subscribe()
    }

    fun reloadFeed() {
        _uiStructure.value = emptyList()
        fetchMainFeed()
    }
}