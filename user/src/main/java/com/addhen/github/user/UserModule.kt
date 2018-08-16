package com.addhen.github.user

import com.addhen.github.users.UserDataRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object UserModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideUserGithubApi(retrofit: Retrofit): UserGithubApi {
        return retrofit.create(UserGithubApi::class.java)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideUserRepository(githubApi: UserGithubApi): UserRepository {
        return UserDataRepository(githubApi)
    }
}
