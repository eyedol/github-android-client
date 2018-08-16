object Dependencies {

    val ktx = "androidx.core:core-ktx:${Versions.KTX}"
    val timber = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    val junit = "junit:junit:${Versions.JUNIT}"

    object Kotlin {
        val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}"
        val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:0.24.0"
    }

    object Support {
        val design = "com.google.android.material:material:${Versions.SUPPORT_LIBRARY}"
        val recyclerView = "androidx.recyclerview:recyclerview:${Versions.SUPPORT_LIBRARY}"
        val customtabs = "androidx.browser:browser:${Versions.SUPPORT_LIBRARY}"
        val cardview = "androidx.cardview:cardview:${Versions.SUPPORT_LIBRARY}"
        val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    }

    object Lifecycle {
        val runtime = "androidx.lifecycle:lifecycle-runtime:${Versions.ARCH_COMPONENTS}"
        val extentions = "androidx.lifecycle:lifecycle-extensions:${Versions.ARCH_COMPONENTS}"
        val compiler = "androidx.lifecycle:lifecycle-compiler:${Versions.ARCH_COMPONENTS}"
    }

    object Retrofit {
        const val core = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
        const val converter = "com.squareup.retrofit2:converter-moshi:${Versions.RETROFIT}"
        const val coroutines = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-experimental-adapter:1.0.0"
    }

    object OkHttp {
        const val core = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
    }

    object Glide {
        val core = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
        val okhttp3 = "com.github.bumptech.glide:okhttp3-integration:${Versions.GLIDE}"
        val compiler = "com.github.bumptech.glide:compiler:${Versions.GLIDE}"
    }

    object Databinding {
        val compiler = "androidx.databinding:databinding-compiler:${Versions.GRADLE_PLUGIN}"
    }

    object Leakcanary {
        val op = "com.squareup.leakcanary:leakcanary-android:${Versions.LEAK_CANARY}"
        val noOp = "com.squareup.leakcanary:leakcanary-android-no-op:${Versions.LEAK_CANARY}"
    }

    object Dagger {
        val core = "com.google.dagger:dagger:${Versions.DAGGER}"
        val android = "com.google.dagger:dagger-android:${Versions.DAGGER}"
        val support = "com.google.dagger:dagger-android-support:${Versions.DAGGER}"
        val compiler = "com.google.dagger:dagger-compiler:${Versions.DAGGER}"
        val processor = "com.google.dagger:dagger-android-processor:${Versions.DAGGER}"
    }

    object Mockito {
        const val kotlin = "com.nhaarman:mockito-kotlin:${Versions.MOCKITO_KOTLIN}"
        const val android = "org.mockito:mockito-android:${Versions.MOCKITO_ANDROID}"
        // TODO replace with config file in test
        const val inline = "org.mockito:mockito-inline:${Versions.MOCKITO_INLINE}"
    }

    object Moshi {
        const val core = "com.squareup.moshi:moshi-adapters:${Versions.MOSHI}"
    }
}
