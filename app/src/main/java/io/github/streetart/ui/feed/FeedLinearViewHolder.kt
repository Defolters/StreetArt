package io.github.streetart.ui.feed

import android.support.v7.widget.CardView
import android.view.View
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import io.github.streetart.R


class FeedLinearViewHolder(itemView: View)
    : RecyclerView.ViewHolder(itemView){

    val image: ImageView = itemView.findViewById(R.id.image_art)
    val name: TextView = itemView.findViewById(R.id.name_art)
    val author: TextView = itemView.findViewById(R.id.author_art)
    val item: CardView = itemView.findViewById(R.id.art_item)

}