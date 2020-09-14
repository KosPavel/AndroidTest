package com.kospavel.androidtest.ui.mainfeed

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kospavel.androidtest.R

class MainFeedFragment : Fragment(R.layout.fragment_main_feed) {

    private val vm: MainFeedViewModel by viewModels()

    override fun onResume() {
        super.onResume()
        vm.fetchMainFeed()
        vm.uiStructure.observeForever {
            Log.i("qwerty", it.size.toString())
            Log.i("qwerty", it.toString())
        }
    }
}