package com.kospavel.androidtest.ui.mainfeed

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kospavel.androidtest.R

data class Post(
    val author: String,
    val title: String
)

class FeedAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items = listOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val titleTextView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_post_view, parent, false)
        return FeedViewHolder(titleTextView)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.itemView.text = items[position].title
    }

    class FeedViewHolder(itemView: TextView) : RecyclerView.ViewHolder(itemView)

}