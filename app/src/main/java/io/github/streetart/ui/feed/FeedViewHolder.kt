package io.github.streetart.ui.feed

import android.content.Context
import android.support.v7.widget.CardView
import android.view.View
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import io.github.streetart.R



class FeedViewHolder(itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    val image: ImageView
    val name: TextView
    val author: TextView
    val item: CardView

    init {
        image = itemView.findViewById(R.id.image_art)
        name = itemView.findViewById(R.id.name_art)
        author = itemView.findViewById(R.id.author_art)
        item = itemView.findViewById(R.id.art_item)
    }

}