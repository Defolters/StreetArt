package io.github.streetart.ui.detail

import io.github.streetart.network.model.Artwork

interface DetailContract {
    interface View {
        fun showArt(artwork: Artwork)
//        fun showArts(artworks: List<Artwork>)
//        fun showArtDetails(requestedArtId: String)

    }

    interface Presenter {
        fun getArtwork(id: String)
//        fun loadArts(forceUpdate: Boolean)
//        fun openArtDetails(requestedArtId: Artwork)
    }
}