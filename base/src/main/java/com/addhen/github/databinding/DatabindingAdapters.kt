package com.addhen.github.databinding

import android.text.TextUtils
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.addhen.github.GlideApp
import com.addhen.github.base.R
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop


@BindingAdapter(value = ["userImageUrl", "userImageSize"])
fun setUserImageUrlWithSize(imageView: ImageView, imageUrl: String?,
                            sizeInDimen: Float) {
    setImageUrlWithSize(imageView, imageUrl, sizeInDimen, R.drawable.ic_user_placeholder)
}

private fun setImageUrlWithSize(imageView: ImageView, imageUrl: String?,
                                sizeInDimen: Float, placeholderResId: Int) {
    if (TextUtils.isEmpty(imageUrl)) {
        imageView.setImageDrawable(ContextCompat.getDrawable(imageView.context, placeholderResId))
    } else {
        val size = Math.round(sizeInDimen)
        imageView.background = ContextCompat.getDrawable(
            imageView.context, R.drawable.circle_border_grey200
        )
        GlideApp.with(imageView.context)
            .load(imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .override(size, size)
            .centerCrop()
            .placeholder(placeholderResId)
            .error(placeholderResId)
            .transform(CircleCrop())
            .into(imageView)
    }
}

