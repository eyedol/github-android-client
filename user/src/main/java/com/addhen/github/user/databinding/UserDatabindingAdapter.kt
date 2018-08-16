package com.addhen.github.user.databinding

import android.text.TextUtils
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.addhen.github.user.model.R
import com.addhen.github.user.model.User

@BindingAdapter("userName")
fun setUsername(textView: TextView, user: User) {
    textView.text = if (!TextUtils.isEmpty(user.username)) {
        "@${user.username}"
    } else {
        user.name
    }

}

@BindingAdapter("bioInfo")
fun setBioInfo(textView: TextView, user: User) {
    textView.text = if (user.bio.isNullOrEmpty()) user.bio else textView.context.getText(R.string.no_bio)
}
