package com.addhen.github

import com.addhen.github.di.DaggerAppComponent
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector() = DaggerAppComponent.builder().create(this)
}
