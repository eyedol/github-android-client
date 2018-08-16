package com.addhen.github.users

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object UsersModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideGithubService(retrofit: Retrofit): UsersGithubApi {
        return retrofit.create(UsersGithubApi::class.java)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideUsersRepository(githubApi: UsersGithubApi): UsersRepository {
        return UsersDataRepository(githubApi)
    }
}
