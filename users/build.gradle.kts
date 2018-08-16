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
    implementation(project(":base"))
    implementation(project(":user-model"))
    kapt(Dependencies.Databinding.compiler)
    kapt(Dependencies.Dagger.compiler)
    kapt(Dependencies.Dagger.processor)
    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.Mockito.android)
    testImplementation(Dependencies.Mockito.kotlin)
    testImplementation(Dependencies.Mockito.inline)
}
