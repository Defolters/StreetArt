package io.github.streetart.ui.detail

import android.util.Log
import io.github.streetart.data.ArtsDataSource
import io.github.streetart.data.ArtsRepository
import io.github.streetart.network.model.Artwork

class DetailPresenter (val detailView: DetailContract.View) : DetailContract.Presenter {
    override fun getArtwork(id: String) {

        ArtsRepository.getRepository().getArt(id, object: ArtsDataSource.GetArtCallback {
            override fun onArtLoaded(art: Artwork) {
                detailView.showArt(art)
            }

            override fun onFailed() {
                Log.d("DETAIL_PRESENTER", "ArtLoading failed")
            }
        })


    }
}