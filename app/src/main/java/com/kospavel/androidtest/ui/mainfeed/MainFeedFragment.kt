package com.kospavel.androidtest.ui.mainfeed

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.kospavel.androidtest.App
import com.kospavel.androidtest.R
import kotlinx.android.synthetic.main.fragment_main_feed.*
import retrofit2.Retrofit
import javax.inject.Inject

class MainFeedFragment : Fragment(R.layout.fragment_main_feed) {

    private val vm: MainFeedViewModel by viewModels()

    @Inject
    lateinit var retrofit: Retrofit

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        App.get(requireContext()).appComponent.inject(this)

        val feedAdapter = FeedAdapter()

        feed_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = feedAdapter
        }

        vm.apply {
            fetchMainFeed()
            uiStructure.observeForever {
                feedAdapter.items = it
                feedAdapter.notifyDataSetChanged()
            }
        }

        swipe_container.setOnRefreshListener {
            vm.reloadFeed()
            swipe_container.isRefreshing = false
        }
    }
}