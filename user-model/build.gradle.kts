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
    implementation(Dependencies.Kotlin.stdLib)
    api(Dependencies.Moshi.core)
    kapt(Dependencies.Databinding.compiler)
}
