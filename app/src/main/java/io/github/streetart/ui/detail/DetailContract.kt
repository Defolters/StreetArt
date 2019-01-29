package io.github.streetart.ui.detail

import io.github.streetart.network.model.Artwork

interface DetailContract {
    interface View {
        fun showArt(artwork: Artwork)
    }

    interface Presenter {
        fun getArtwork(id: String)
    }
}