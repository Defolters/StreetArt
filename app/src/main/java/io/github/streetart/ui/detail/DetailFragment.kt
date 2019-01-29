package io.github.streetart.ui.detail


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import io.github.streetart.R


class DetailFragment : Fragment() {

    private lateinit var id: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)


        return view
    }

    companion object {

        fun newInstance(requestedArtId: String) = DetailFragment()
            .apply {
                id = requestedArtId
            }
    }

}
