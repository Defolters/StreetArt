package io.github.streetart.ui.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import io.github.streetart.R

class DetailActivity : AppCompatActivity() {

    private val DETAIL_FRAGMENT_TAG = "detailFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val requestedArtId = intent.getStringExtra(ART_ID)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        var detailFragment = supportFragmentManager.findFragmentByTag(DETAIL_FRAGMENT_TAG) as? DetailFragment
        if (detailFragment == null) {
            detailFragment = DetailFragment.newInstance(requestedArtId)
            supportFragmentManager.beginTransaction()
                .add(R.id.detail_frame, detailFragment, DETAIL_FRAGMENT_TAG).commit()
        }
        else {
            supportFragmentManager.beginTransaction().show(detailFragment as Fragment).commit()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val ART_ID = "ART_ID"
    }
}
