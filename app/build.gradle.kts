plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(Versions.COMPILE_SDK)
    dataBinding.isEnabled = true
    defaultConfig {
        applicationId = Versions.APPLICATION_ID
        minSdkVersion(Versions.MIN_SDK)
        targetSdkVersion(Versions.TARGET_SDK)
        testApplicationId = "${Versions.APPLICATION_ID}.test"
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        versionCode = 1
        versionName = "1.0"
        val baseUrl = "https://api.github.com/"
        buildConfigField("String", "BASE_URL", "\"${baseUrl}\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFile(getDefaultProguardFile("proguard-android.txt"))
            proguardFile(file("proguard-rules.pro"))
        }
    }
    compileOptions {
        setSourceCompatibility(Versions.SOURCE_COMPATIBILITY)
        setTargetCompatibility(Versions.SOURCE_COMPATIBILITY)
    }
    dexOptions {
        preDexLibraries = "true" != System.getenv("CI")
    }
    lintOptions {
        isCheckDependencies = true
        isIgnoreTestSources = true
    }
}

dependencies {
    implementation(project(":base"))
    implementation(project(":user"))
    implementation(project(":users"))
    implementation(project(":login"))
    kapt(Dependencies.Databinding.compiler)
    kapt(Dependencies.Dagger.compiler)
    kapt(Dependencies.Dagger.processor)
    kapt(Dependencies.Lifecycle.compiler)
    kapt(Dependencies.Glide.compiler)
}
