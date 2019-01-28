package io.github.streetart.ui.feed

import io.github.streetart.network.model.Artwork

class FeedPresenter (val feedView: FeedContract.View)
    : FeedContract.Presenter {

    override fun loadArts(forceUpdate: Boolean) {

        var artwork = Artwork()
        artwork.name = "title"
        var artworks = listOf(artwork)

        feedView.showArts(artworks)
    }

    override fun openArtDetails(requestedTask: Artwork) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}