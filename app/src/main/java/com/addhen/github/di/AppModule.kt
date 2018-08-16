package com.addhen.github.di

import android.content.Context
import com.addhen.github.App
import com.addhen.github.AppRxSchedulers
import com.addhen.github.BuildConfig
import com.addhen.github.RxSchedulers
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.Rfc3339DateJsonAdapter
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.io.File
import java.util.Date
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [
    ViewModelBuilder::class]
)
object AppModule {

    private val DISK_CACHE_SIZE: Long = 50 * 1024 * 1024 // 50MB

    private val HTTP_TIMEOUT = 15L

    @Singleton
    @Provides
    @JvmStatic
    fun provideAppContext(app: App) = app.applicationContext

    @Singleton
    @Provides
    @JvmStatic
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor { message ->
            Timber.tag("OkHttp").d(message)
        }
        loggingInterceptor.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.BASIC
        }
        return loggingInterceptor
    }

    @Singleton
    @Provides
    @JvmStatic
    fun provideOkHttpClient(
        context: Context,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
        val cacheDir = File(context.applicationContext.cacheDir, "app-http-cache")
        val cache = Cache(cacheDir, DISK_CACHE_SIZE)
        okHttpClientBuilder.cache(cache)
        initOkHttpBuilder(okHttpClientBuilder, loggingInterceptor)
        return okHttpClientBuilder.build()
    }


    @Singleton
    @Provides
    @JvmStatic
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(Date::class.java, Rfc3339DateJsonAdapter())
            .build()
    }

    @Singleton
    @Provides
    @JvmStatic
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .build()
    }


    @Singleton
    @Provides
    @JvmStatic
    fun provideRxScheduler(): RxSchedulers {
        return AppRxSchedulers()
    }

    private fun initOkHttpBuilder(
        okHttpClientBuilder: OkHttpClient.Builder,
        loggingInterceptor: HttpLoggingInterceptor
    ) {
        okHttpClientBuilder.connectTimeout(HTTP_TIMEOUT, TimeUnit.SECONDS)
        okHttpClientBuilder.writeTimeout(HTTP_TIMEOUT, TimeUnit.SECONDS)
        okHttpClientBuilder.readTimeout(HTTP_TIMEOUT, TimeUnit.SECONDS)
        okHttpClientBuilder.addInterceptor(loggingInterceptor)
    }
}
