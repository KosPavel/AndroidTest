package com.kospavel.androidtest.ui.mainfeed

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kospavel.androidtest.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class MainFeedFragment : Fragment(R.layout.fragment_main_feed) {

    private val vm: MainFeedViewModel by viewModels()

    override fun onResume() {
        super.onResume()
        vm.best().observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                Log.i("qwerty", it.toString())
            }
            .subscribe()
    }

}