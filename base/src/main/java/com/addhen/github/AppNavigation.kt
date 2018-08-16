package com.addhen.github

import android.content.Context
import android.content.Intent
import android.net.Uri
import javax.inject.Inject

class AppNavigation @Inject constructor(private val context: Context) {

    companion object {

        const val EXTRA_USER_NAME = "EXTRA_USER_NAME"
        private const val URL_BASE = "https://github.addhen.com"
        private const val URL_USERS = "$URL_BASE/users"
        private const val URL_USER = "$URL_BASE/user"
        private const val URL_LOGIN = "$URL_BASE/login"

    }


    fun navigateToUser(username: String) {
        val userIntent = baseIntent(URL_USER, context)
        userIntent.putExtra(EXTRA_USER_NAME, username)
        context.startActivity(userIntent)
    }

    fun navigateToUsers() {
        val usersIntent = baseIntent(URL_USERS, context)
        context.startActivity(usersIntent)
    }

    private fun baseIntent(url: String, context: Context? = null): Intent {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            .addCategory(Intent.CATEGORY_DEFAULT)
            .addCategory(Intent.CATEGORY_BROWSABLE)
        if (context != null) {
            intent.`package` = context.packageName
        }
        return intent
    }
}
