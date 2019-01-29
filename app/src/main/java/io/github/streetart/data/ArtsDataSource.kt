package io.github.streetart.data

import io.github.streetart.network.model.Artwork

interface ArtsDataSource {

    interface LoadArtsCallback {
        fun onArtsLoaded(arts: List<Artwork>)

        fun onFailed()
    }

    interface GetArtCallback {
        fun onArtLoaded(art: Artwork)

        fun onFailed()
    }

    fun getArts(forceUpdate: Boolean ,callback: LoadArtsCallback)

    fun getArt(id: String, callback: GetArtCallback)
}