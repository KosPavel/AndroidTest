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
            .map {
                when (it) {
                    is MainFeedResponseStatus.Ok -> {
                        _uiStructure.value = setStructure(it.rawPostData)
                    }
                    is MainFeedResponseStatus.Error -> {
                        _uiStructure.value = listOf(NoPosts())
                    }
                }
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
//        setStructure().subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe()
    }
}