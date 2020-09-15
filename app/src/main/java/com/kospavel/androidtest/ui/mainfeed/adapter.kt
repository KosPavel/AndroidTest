package com.kospavel.androidtest.ui.mainfeed

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateLayoutContainer
import com.kospavel.androidtest.R
import kotlinx.android.synthetic.main.item_post_view.*

fun postAdapterDelegate() = adapterDelegateLayoutContainer<Post, Any>(R.layout.item_post_view) {

    bind {
        post_title.text = item.title
    }

}