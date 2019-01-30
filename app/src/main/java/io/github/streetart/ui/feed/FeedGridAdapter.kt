package io.github.streetart.ui.feed

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.streetart.R
import io.github.streetart.loadImage
import io.github.streetart.loadImageGlide
import io.github.streetart.network.model.Artwork

class FeedGridAdapter (
    private var data: List<Artwork>?,
    private val presenter: FeedPresenter
)
    : RecyclerView.Adapter<FeedGridViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): FeedGridViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.art_grid_item, parent, false)
        return FeedGridViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: FeedGridViewHolder, position: Int) {

        if (!data!![position].photos.isNullOrEmpty()) {
            holder.image.loadImageGlide(data!![position].photos[0].image)
        }

        holder.image.setOnClickListener {
            presenter.openArtDetails(data!![position])
        }
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}