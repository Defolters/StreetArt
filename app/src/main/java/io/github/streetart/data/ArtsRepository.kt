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

    override fun getArts(forceUpdate: Boolean, callback: ArtsDataSource.LoadArtsCallback) {
        if (forceUpdate) {
            loadFromRemote(callback)
        } else {
            loadFromCache(callback)
        }
        //callback.onArtsLoaded(artworks)
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

                val newArtworks = processArtworks(response.body()!!)

                artworks = newArtworks
                Paper.book().write("cache", Gson().toJson(newArtworks))

                callback.onArtsLoaded(newArtworks)
            }

            override fun onFailure(call: Call<Artworks>, t: Throwable) {
                Log.d("ARTS_REPOSITORY", "onFailure")
            }
        })

    }

    private fun processArtworks(artworks: Artworks): MutableList<Artwork> {
        var newArtworks = mutableListOf<Artwork>()
        artworks.forEach {
            if (!it.photos.isNullOrEmpty() && !it.photos[0].image.isNullOrBlank()) {
                it.name.trim()
                newArtworks.add(it)
            }
        }
        return newArtworks
    }

    companion object {

        private var repository: ArtsRepository? = null

        fun getRepository() : ArtsRepository {
            return repository ?: ArtsRepository()
                .apply { repository = this }
        }
    }
}