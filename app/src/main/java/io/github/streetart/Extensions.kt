package io.github.streetart

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso


fun ImageView.loadImage(path: String?) {
    if (path?.isNotBlank() == true) {
        Picasso.get().load(path).into(this)
    }
}

fun ImageView.loadImageGlide(path: String?) {
    if (path?.isNotBlank() == true) {
        Glide.with(context).load(path).thumbnail(0.1f).skipMemoryCache(true).into(this)
    }
}
