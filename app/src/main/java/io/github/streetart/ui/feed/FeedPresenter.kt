package io.github.streetart.ui.feed

import android.util.Log
import io.github.streetart.data.ArtsDataSource
import io.github.streetart.data.ArtsRepository
import io.github.streetart.network.model.Artwork

class FeedPresenter (val feedView: FeedContract.View)
    : FeedContract.Presenter {

    override fun loadArts(forceUpdate: Boolean) {

        ArtsRepository.getRepository().getArts(forceUpdate, object: ArtsDataSource.LoadArtsCallback {
            override fun onArtsLoaded(arts: List<Artwork>) {
                feedView.showArts(arts)
            }

            override fun onFailed() {
                Log.d("FEED_PRESENTER", "ArtsLoading failed")
            }
        })
    }

    override fun openArtDetails(requestedArt: Artwork) {
        feedView.showArtDetails(requestedArt.id)
    }

}