package io.github.streetart

import android.widget.ImageView
import com.squareup.picasso.Picasso


fun ImageView.loadImage(path: String?) {
    if (path?.isNotBlank() == true) {
        Picasso.get().load(path).into(this)
    }
}
