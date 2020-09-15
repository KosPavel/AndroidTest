package com.kospavel.androidtest.ui.mainfeed

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.kospavel.androidtest.R
import kotlinx.android.synthetic.main.fragment_main_feed.*

class MainFeedFragment : Fragment(R.layout.fragment_main_feed) {

    private val vm: MainFeedViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val feedAdapter = ListDelegationAdapter(
//            postAdapterDelegate()
//        )
        val feedAdapter = FeedAdapter()

        feed_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = feedAdapter
        }

        vm.fetchMainFeed()
        vm.uiStructure.observeForever {
            Log.i("qwerty", it.size.toString())
            Log.i("qwerty", it.toString())
            feedAdapter.items = it
            feedAdapter.notifyDataSetChanged()
        }
    }
}