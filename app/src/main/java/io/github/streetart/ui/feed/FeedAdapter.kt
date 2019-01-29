package io.github.streetart.ui.feed

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.streetart.R
import io.github.streetart.loadImage
import io.github.streetart.network.model.Artwork

class FeedAdapter (private val context: Context, private var data: List<Artwork>?)
    : RecyclerView.Adapter<FeedViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): FeedViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.art_item, parent, false)
        return FeedViewHolder(this.context, rootView)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
//        holder.author.text = data!![position].artists[0].name
//        holder.author.text = data!![position].artists.joinToString()
        holder.name.text = data!![position].name
        if (!data!![position].photos.isNullOrEmpty()) {
            holder.image.loadImage(data!![position].photos[0].image)
        }

        holder.item.setOnClickListener {
            Log.d("FEED_ADAPTER", "$position item clicked")
        }
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

//    override fun getItemId(position: Int): Long {
//        return super.getItemId(position)
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return super.getItemViewType(position)
//    }
}