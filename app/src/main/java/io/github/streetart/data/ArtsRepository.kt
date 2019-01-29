package io.github.streetart.data

import android.util.Log
import com.google.gson.Gson
import io.github.streetart.network.RetrofitClient
import io.github.streetart.network.model.*
import io.paperdb.Paper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArtsRepository : ArtsDataSource{

    var artworks = mutableListOf<Artwork>()

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
        artwork3.id = "32"
        val photo3 = Photo()
        photo3.image = "https://pp.userapi.com/c850432/v850432621/9e94b/KStEsVr6Ckg.jpg"
        artwork3.photos.add(photo3)

        artworks.add(artwork)
        artworks.add(artwork2)
        artworks.add(artwork3)
    }

    override fun getArts(forceUpdate: Boolean, callback: ArtsDataSource.LoadArtsCallback) {
        if (forceUpdate) {
            loadFromRemote(callback)
        } else {
            loadFromCache(callback)
        }
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

    private fun findArt(id: String) : Artwork? {
        artworks.forEach {
            if (it.id == id)
                return it
        }
        return null
    }

    private fun loadFromCache(callback: ArtsDataSource.LoadArtsCallback) {
        val cache = Paper.book().read<String>("cache")

        if (!(cache.isNullOrBlank() || cache == "null")) {
            val newArtworks = Gson().fromJson<Artworks>(cache, Artworks::class.java)
            artworks = newArtworks

            callback.onArtsLoaded(newArtworks)
        } else {
            loadFromRemote(callback)
        }

    }

    private fun loadFromRemote(callback: ArtsDataSource.LoadArtsCallback) {

        RetrofitClient().getArtworksEndpoint().getArtworks().enqueue(object: Callback<Artworks> {
            override fun onResponse(call: Call<Artworks>, response: Response<Artworks>) {

                if (response.body() == null) {
                    return
                }

                val newArtworks = response.body()!!
                artworks = newArtworks

                Paper.book().write("cache", Gson().toJson(response.body()))

                callback.onArtsLoaded(newArtworks)
            }

            override fun onFailure(call: Call<Artworks>, t: Throwable) {
                Log.d("ARTS_REPOSITORY", "onFailure\n"+t)
            }
        })

    }

    companion object {

        private var repository: ArtsRepository? = null

        fun getRepository() : ArtsRepository {
            return repository ?: ArtsRepository()
                .apply { repository = this }
        }
    }
}