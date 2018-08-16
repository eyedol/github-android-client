package com.addhen.github.di

import com.addhen.github.App
import com.addhen.github.user.UserModule
import com.addhen.github.users.UsersModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBuilder::class,
    AppModule::class,
    UsersModule::class,
    UserModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}
