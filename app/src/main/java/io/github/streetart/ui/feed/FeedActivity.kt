package io.github.streetart.ui.feed

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import io.github.streetart.R
import io.paperdb.Paper

class FeedActivity : AppCompatActivity() {

    private val FEED_FRAGMENT_TAG = "feedFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        Paper.init(this)

        var feedFragment = supportFragmentManager.findFragmentByTag(FEED_FRAGMENT_TAG) as? FeedFragment
        if (feedFragment == null) {
            feedFragment = FeedFragment.newInstance()
            supportFragmentManager.beginTransaction()
                .add(R.id.feed_frame, feedFragment, FEED_FRAGMENT_TAG).commit()
        }
        else {
            supportFragmentManager.beginTransaction().show(feedFragment as Fragment)
        }
    }
}
