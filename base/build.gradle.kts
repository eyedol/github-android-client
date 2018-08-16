plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {

    compileSdkVersion(Versions.COMPILE_SDK)
    dataBinding.isEnabled = true
    defaultConfig {
        minSdkVersion(Versions.MIN_SDK)
        targetSdkVersion(Versions.TARGET_SDK)
    }
}

dependencies {

    api(Dependencies.Kotlin.stdLib)
    api(Dependencies.Kotlin.coroutines)
    // Support libraries
    api(Dependencies.Support.design)
    api(Dependencies.Support.recyclerView)
    api(Dependencies.Support.constraintLayout)
    api(Dependencies.ktx)

    api(Dependencies.Retrofit.core) {
        exclude(module = "okhttp")
    }
    api(Dependencies.Retrofit.converter)
    api(Dependencies.Retrofit.coroutines)
    api(Dependencies.OkHttp.core)
    api(Dependencies.OkHttp.loggingInterceptor)
    api(Dependencies.Glide.core)
    api(Dependencies.Glide.okhttp3)
    api(Dependencies.Lifecycle.runtime)
    api(Dependencies.Lifecycle.extentions)
    // Utility
    api(Dependencies.Dagger.core)
    api(Dependencies.Dagger.android)
    api(Dependencies.Dagger.support)
    api(Dependencies.timber)
//  kapt(Dependencies.Room.compiler)
    kapt(Dependencies.Databinding.compiler)
    kapt(Dependencies.Dagger.compiler)
    kapt(Dependencies.Dagger.processor)
    kapt(Dependencies.Lifecycle.compiler)
    kapt(Dependencies.Glide.compiler)
}
