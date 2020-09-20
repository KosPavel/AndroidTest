package com.kospavel.androidtest.ui.mainfeed

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.kospavel.androidtest.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_post_view.view.*

class FeedAdapter : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    var items = listOf<Any>()

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val layout =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_post_view, parent, false) as LinearLayout
        return FeedViewHolder(layout)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val post = items[position] as Post
        holder.itemView.post_title.text = post.title
        if (post.url.contains(regex = Regex("jpg|gif|png"))) {
            Picasso.get().load(post.url).into(holder.itemView.image)
        } else {
            holder.itemView.image.setImageResource(0)
        }
    }

    class FeedViewHolder(viewGroup: ViewGroup) : RecyclerView.ViewHolder(viewGroup)

}
