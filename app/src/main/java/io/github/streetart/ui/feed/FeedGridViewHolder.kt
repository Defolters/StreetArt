package io.github.streetart.ui.feed

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import io.github.streetart.R

class FeedGridViewHolder (itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    val image: ImageView

    init {
        image = itemView.findViewById(R.id.image_art)
    }
}