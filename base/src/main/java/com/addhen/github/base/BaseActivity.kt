package com.addhen.github.base

import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity(private val menu: Int) : DaggerAppCompatActivity() {

    init {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        if (this.menu != 0) {
            menuInflater.inflate(this.menu, menu)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
