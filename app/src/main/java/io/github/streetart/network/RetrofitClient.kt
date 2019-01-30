package io.github.streetart.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {
    private val URL = "https://street-art-server.herokuapp.com/"
    private var retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getArtworksEndpoint() : ArtworksEndpoint {
        return retrofit.create(ArtworksEndpoint::class.java)
    }
}