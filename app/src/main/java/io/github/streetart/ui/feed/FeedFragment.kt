package io.github.streetart.ui.feed


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import io.github.streetart.R
import io.github.streetart.network.model.Artwork
import io.github.streetart.ui.detail.DetailActivity


class FeedFragment : Fragment(), FeedContract.View{

    private lateinit var artsRecyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    private lateinit var feedPresenter: FeedPresenter
    private var isGrid = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_feed, container, false)

        with(view) {
            swipeRefreshLayout = findViewById(R.id.swipe_refresh)
            artsRecyclerView = findViewById(R.id.arts_list)
        }

        feedPresenter = FeedPresenter(this)
        feedPresenter.loadArts(false)

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = true
            feedPresenter.loadArts(true)
        }

        return view
    }

    override fun showArts(artworks: List<Artwork>) {
        if (isGrid) {

            val layoutManager = GridLayoutManager(activity as Context, 3)
            artsRecyclerView.layoutManager = layoutManager
            val feedAdapter = FeedGridAdapter(artworks, feedPresenter)
            feedAdapter.notifyDataSetChanged()
            artsRecyclerView.adapter = feedAdapter
        } else {

            val layoutManager = LinearLayoutManager(activity as Context)
            artsRecyclerView.layoutManager = layoutManager
            val feedAdapter = FeedLinearAdapter(artworks, feedPresenter)
            feedAdapter.notifyDataSetChanged()
            artsRecyclerView.adapter = feedAdapter
        }
        swipeRefreshLayout.isRefreshing = false
    }

    override fun showArtDetails(requestedArtId: String) {

        val intent = Intent(context, DetailActivity::class.java).apply {
            putExtra(DetailActivity.ART_ID, requestedArtId)
        }
        startActivity(intent)
    }

    fun changeLayout() {
        isGrid = !isGrid
        feedPresenter.loadArts(false)
    }

    companion object {

        fun newInstance() = FeedFragment()
    }
}
