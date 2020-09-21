package com.kospavel.androidtest.ui.mainfeed

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.kospavel.androidtest.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_post_view.view.*

class FeedAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items = listOf<Any>()

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is NoPosts -> 1
            is RawPostData -> 2
            else -> 0
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> {
                val layout = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_no_posts_view, parent, false) as LinearLayout
                NoPostsViewHolder(layout)
            }
            2 -> {
                val layout =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_post_view, parent, false) as LinearLayout
                FeedViewHolder(layout)
            }
            else -> {
                val layout =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.unknown_post_type_view, parent, false) as LinearLayout
                UnknownPostTypeViewHolder(layout)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            2 -> {
                val post = items[position] as RawPostData
                holder.itemView.post_title.text = post.title
                if (post.url.contains(regex = Regex("jpg|gif|png"))) {
                    Picasso.get().load(post.url).into(holder.itemView.image)
                } else {
                    holder.itemView.image.setImageResource(0)
                }
            }
        }
    }

    class FeedViewHolder(viewGroup: ViewGroup) : RecyclerView.ViewHolder(viewGroup)

    class NoPostsViewHolder(viewGroup: ViewGroup) : RecyclerView.ViewHolder(viewGroup)

    class UnknownPostTypeViewHolder(viewGroup: ViewGroup) : RecyclerView.ViewHolder(viewGroup)
}
