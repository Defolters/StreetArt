package io.github.streetart.ui.feed

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import io.github.streetart.R

class FeedActivity : AppCompatActivity() {

    var feedFragment: FeedFragment? = null
    private val FEED_FRAGMENT_TAG = "feedFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        feedFragment = supportFragmentManager.findFragmentByTag(FEED_FRAGMENT_TAG) as? FeedFragment
        if (feedFragment == null) {
            feedFragment = FeedFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.feed_frame, feedFragment!!, FEED_FRAGMENT_TAG).commit()
        }
        else {
            supportFragmentManager.beginTransaction().show(feedFragment as Fragment)
        }
    }

}
