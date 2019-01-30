package io.github.streetart.ui.feed

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import io.github.streetart.R
import io.paperdb.Paper

class FeedActivity : AppCompatActivity() {

    private val FEED_FRAGMENT_TAG = "feedFragment"
    private var feedFragment: FeedFragment? = null
    private var isGrid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        Paper.init(this)

        feedFragment = supportFragmentManager.findFragmentByTag(FEED_FRAGMENT_TAG) as? FeedFragment
        if (feedFragment == null) {
            feedFragment = FeedFragment.newInstance()
            supportFragmentManager.beginTransaction()
                .add(R.id.feed_frame, feedFragment as FeedFragment, FEED_FRAGMENT_TAG).commit()
        }
        else {
            supportFragmentManager.beginTransaction().show(feedFragment as Fragment).commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item!!.itemId) {
            R.id.change_layout_action -> {
                feedFragment!!.changeLayout()

                isGrid = !isGrid
                if (isGrid) {
                    item.setIcon(R.drawable.ic_list_24dp)
                } else {
                    item.setIcon(R.drawable.ic_grid_on_24dp)
                }

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
