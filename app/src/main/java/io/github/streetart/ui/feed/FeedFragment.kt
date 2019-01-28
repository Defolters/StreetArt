package io.github.streetart.ui.feed


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import io.github.streetart.R
import io.github.streetart.network.model.Art


class FeedFragment : Fragment(), FeedContract.View{

    private lateinit var artsRecyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    private lateinit var feedPresenter: FeedPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_feed, container, false)

        with(view) {
            artsRecyclerView = findViewById(R.id.swipe_refresh)
            swipeRefreshLayout = findViewById(R.id.arts_list)
        }

        feedPresenter = FeedPresenter(this)
        feedPresenter.loadArts(false)

        return view
    }

    override fun showArts(arts: List<Art>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showArtDetails() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
