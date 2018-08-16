package com.addhen.github.di

import com.addhen.github.login.LoginActivity
import com.addhen.github.user.UserActivity
import com.addhen.github.users.UsersActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBuilder {

    @ContributesAndroidInjector
    internal abstract fun usersActivity(): UsersActivity

    @ContributesAndroidInjector
    internal abstract fun userActivity(): UserActivity

    @ContributesAndroidInjector
    internal abstract fun loginActivity(): LoginActivity
}
