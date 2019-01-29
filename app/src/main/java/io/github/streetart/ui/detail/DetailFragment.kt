package io.github.streetart.ui.detail


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView

import io.github.streetart.R
import io.github.streetart.loadImage
import io.github.streetart.network.model.Artwork


class DetailFragment : Fragment(), DetailContract.View {

    private lateinit var id: String
    private lateinit var nameTextView: TextView
    private lateinit var authorTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var addressTextView: TextView
    private lateinit var imageView: ImageView
    private lateinit var mapFrame: FrameLayout

    private lateinit var detailPresenter: DetailPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        with(view) {
            nameTextView = findViewById(R.id.name_art)
            authorTextView = findViewById(R.id.author_art)
            descriptionTextView = findViewById(R.id.description_art)
            addressTextView = findViewById(R.id.address_art)
            imageView = findViewById(R.id.image_art)
            mapFrame = findViewById(R.id.map_art)
        }

        detailPresenter = DetailPresenter(this)
        detailPresenter.getArtwork(id)

        // set up map

        return view
    }

    override fun showArt(artwork: Artwork) {
        with(artwork) {
            if (!name.isNullOrBlank()){
                nameTextView.text = name
            }
            if (!artists.isNullOrEmpty()) {
                authorTextView.text = artists[0].name
            }
            if (!description.isNullOrBlank()) {
                descriptionTextView.text = description
            }
            if (location != null) {
                addressTextView.text = location.address
            }
            if (!photos.isNullOrEmpty()) {
                imageView.loadImage(photos[0].image)
            }
            // map set coordinates
        }


    }

    companion object {

        fun newInstance(requestedArtId: String) = DetailFragment()
            .apply {
                id = requestedArtId
            }
    }

}
