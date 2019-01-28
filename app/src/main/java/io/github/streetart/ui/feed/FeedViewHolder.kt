package io.github.streetart.ui.feed

import android.content.Context
import android.view.View
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import io.github.streetart.R



class FeedViewHolder(context: Context, itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    val image: ImageView
    val name: TextView
    val author: TextView

    init {
        image = itemView.findViewById(R.id.image_art)
        name = itemView.findViewById(R.id.name_art)
        author = itemView.findViewById(R.id.author_art)
    }

}