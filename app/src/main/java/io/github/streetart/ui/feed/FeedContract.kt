package io.github.streetart.ui.feed

import io.github.streetart.network.model.Artwork

interface FeedContract {
    interface View {
        fun showArts(artworks: List<Artwork>)
        fun showArtDetails(requestedArtId: String)

    }

    interface Presenter {
        fun loadArts(forceUpdate: Boolean)
        fun openArtDetails(requestedArt: Artwork)
    }
}