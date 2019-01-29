package io.github.streetart.ui.feed

import io.github.streetart.data.ArtsRepository
import io.github.streetart.network.model.Artist
import io.github.streetart.network.model.Artwork
import io.github.streetart.network.model.Photo

class FeedPresenter (val feedView: FeedContract.View)
    : FeedContract.Presenter {

    var artsRepository: ArtsRepository? = ArtsRepository.getRepository()

    override fun loadArts(forceUpdate: Boolean) {

        val artwork = Artwork()
        artwork.name = "title"
        artwork.id = "12"

        val photo = Photo()
        photo.image = "https://pp.userapi.com/c845017/v845017636/15a577/Xg5jb04BuNM.jpg"
        artwork.photos.add(photo)

        val artist = Artist()
        artist.name = "Michel"

        artwork.artists.add(artist)

        val artwork2 = Artwork()
        artwork2.name = "title"
        val photo2 = Photo()
        photo2.image = "https://pp.userapi.com/c848416/v848416693/117555/A-yykNJyYsw.jpg"
        artwork2.photos.add(photo2)
        val artist2 = Artist()
        artist2.name = "Mark"
        artwork2.artists.add(artist2)
        artwork.id = "32"

        val artwork3 = Artwork()
        artwork3.name = "title"
        val photo3 = Photo()
        photo3.image = "https://pp.userapi.com/c850432/v850432621/9e94b/KStEsVr6Ckg.jpg"
        artwork3.photos.add(photo3)
        val artist3 = Artist()
        artist3.name = "Mark"
        artwork3.artists.add(artist3)
        artwork.id = "32"

        val artworks = listOf(artwork, artwork2, artwork3,artwork,artwork,artwork)

        feedView.showArts(artworks)
    }

    override fun openArtDetails(requestedArt: Artwork) {
        feedView.showArtDetails(requestedArt.id)
    }

}