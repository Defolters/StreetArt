package io.github.streetart.network

import io.github.streetart.network.model.Artworks
import retrofit2.Call
import retrofit2.http.GET

interface ArtworksEndpoint {
    @GET("artworks")
    fun getArtworks(): Call<Artworks>
}