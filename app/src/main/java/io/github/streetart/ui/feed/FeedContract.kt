package io.github.streetart.ui.feed

import io.github.streetart.network.model.Art

interface FeedContract {
    interface View {
        fun showArts(arts: List<Art>)
        fun showArtDetails()

    }

    interface Presenter {
        fun loadArts(forceUpdate: Boolean)
        fun openArtDetails(requestedTask: Art)
    }
}