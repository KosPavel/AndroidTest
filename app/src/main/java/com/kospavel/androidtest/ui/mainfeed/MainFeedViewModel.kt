package com.kospavel.androidtest.ui.mainfeed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kospavel.androidtest.ui.mainfeed.mainfeedrepository.MainFeedRepositoryImpl
import com.kospavel.androidtest.ui.mainfeed.mainfeedrepository.MainFeedResponseStatus
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
                        setStructure(it.rawPostData)
                    }
                    is MainFeedResponseStatus.Error -> {
                        listOf(NoPosts())
                    }
                }
                structure
            }
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                _uiStructure.value = it
            }
            .subscribe()
    }

    private fun setStructure(items: List<RawPostData>): List<Post> {
        val structure = mutableListOf<Post>()
        for (rawPost in items) {
            val singlePost = mutableListOf<Any>()
            singlePost.add(Title(rawPost.title))
            singlePost.add(Author(rawPost.author))
            structure.add(
                Post(singlePost)
            )
        }
        return structure
    }

    fun reloadFeed() {
        _uiStructure.value = emptyList()
        fetchMainFeed()
    }
}