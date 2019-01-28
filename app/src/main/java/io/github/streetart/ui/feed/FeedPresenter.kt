package io.github.streetart.ui.feed

import io.github.streetart.network.model.Artist
import io.github.streetart.network.model.Artwork
import io.github.streetart.network.model.Photo

class FeedPresenter (val feedView: FeedContract.View)
    : FeedContract.Presenter {

    override fun loadArts(forceUpdate: Boolean) {

        val artwork = Artwork()
        artwork.name = "title"

        val photo = Photo()
        photo.image = "https://pp.userapi.com/c845017/v845017636/15a577/Xg5jb04BuNM.jpg"
        artwork.photos.add(photo)

        val artist = Artist()
        artist.name = "Michel"

        var artworks = listOf(artwork, artwork, artwork,artwork,artwork,artwork)

        feedView.showArts(artworks)
    }

    override fun openArtDetails(requestedTask: Artwork) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}