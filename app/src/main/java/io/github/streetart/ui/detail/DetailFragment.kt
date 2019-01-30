package io.github.streetart.ui.detail


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import io.github.streetart.R
import io.github.streetart.loadImage
import io.github.streetart.network.model.Artwork


class DetailFragment : Fragment(), DetailContract.View, OnMapReadyCallback {

    private lateinit var id: String
    private lateinit var nameTextView: TextView
    private lateinit var authorTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var addressTextView: TextView
    private lateinit var imageView: ImageView

    private lateinit var detailPresenter: DetailPresenter

    private var mMap: GoogleMap? = null
    private var mapPosition: LatLng? = null

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
        }

        detailPresenter = DetailPresenter(this)
        detailPresenter.getArtwork(id)

        // set up map
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

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
                mapPosition = LatLng(location.lat, location.lng)//if null
                setMarker()
            }
            if (!photos.isNullOrEmpty()) {
                imageView.loadImage(photos[0].image)
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap!!
        setMarker()
    }

    private fun setMarker() {
        if ((mapPosition != null) && (mMap != null)) {
            (mMap as GoogleMap).addMarker(MarkerOptions().position(mapPosition as LatLng))
            (mMap as GoogleMap).moveCamera(CameraUpdateFactory.newLatLngZoom(mapPosition, 16f))
        }
    }

    companion object {

        fun newInstance(requestedArtId: String) = DetailFragment()
            .apply {
                id = requestedArtId
            }
    }

}
