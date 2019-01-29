package io.github.streetart.data

import io.github.streetart.network.model.Artist
import io.github.streetart.network.model.Artwork
import io.github.streetart.network.model.Location
import io.github.streetart.network.model.Photo

class ArtsRepository : ArtsDataSource{

    val artworks = mutableListOf<Artwork>()

    init {
        val artwork = Artwork()
        artwork.name = "title"
        artwork.id = "12"
        artwork.description = "Text description"
        val photo = Photo()
        photo.image = "https://pp.userapi.com/c845017/v845017636/15a577/Xg5jb04BuNM.jpg"
        artwork.photos.add(photo)
        val artist = Artist()
        artist.name = "Michael"
        artwork.artists.add(artist)
        val location = Location()
        location.address = "NY Street"
        artwork.location = location

        val artwork2 = Artwork()
        artwork2.name = "title"
        artwork2.id = "22"
        artwork2.description = "Text description"
        val photo2 = Photo()
        photo2.image = "https://pp.userapi.com/c848416/v848416693/117555/A-yykNJyYsw.jpg"
        artwork2.photos.add(photo2)
        val artist2 = Artist()
        artist2.name = "Mark"
        artwork2.artists.add(artist2)
        val location2 = Location()
        location2.address = "NY Street"
        artwork2.location = location2

        val artwork3 = Artwork()
        artwork3.name = "title"
        artwork3.id = "32"
        artwork3.description = "Text description"
        val photo3 = Photo()
        photo3.image = "https://pp.userapi.com/c850432/v850432621/9e94b/KStEsVr6Ckg.jpg"
        artwork3.photos.add(photo3)
        val artist3 = Artist()
        artist3.name = "Mark"
        artwork3.artists.add(artist3)
        val location3 = Location()
        location3.address = "NY Street"
        artwork3.location = location3

        artworks.add(artwork)
        artworks.add(artwork2)
        artworks.add(artwork3)
    }

    override fun getArts(forceUpdate: Boolean, callback: ArtsDataSource.LoadArtsCallback) {
        callback.onArtsLoaded(artworks)
    }

    override fun getArt(id: String, callback: ArtsDataSource.GetArtCallback) {
        val artwork = findArt(id)

        if (artwork != null) {
            callback.onArtLoaded(artwork)
        } else {
            callback.onFailed()
        }
    }

    override fun clearAllArts() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun findArt(id: String) : Artwork? {
        artworks.forEach {
            if (it.id == id)
                return it
        }
        return null
    }

    companion object {

        private var repository: ArtsRepository? = null

        fun getRepository() : ArtsRepository {
            return repository ?: ArtsRepository()
                .apply { repository = this }
        }
    }
}