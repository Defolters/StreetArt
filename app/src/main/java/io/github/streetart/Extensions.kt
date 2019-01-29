package io.github.streetart

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import android.R



fun ImageView.loadImage(path: String?) {
    if (path?.isNotBlank() == true) {
        val options = RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate()
        Glide.with(context).load(path).apply(options).into(this)
    }
}