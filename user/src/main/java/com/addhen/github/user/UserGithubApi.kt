package com.addhen.github.user

import com.addhen.github.user.model.User
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface UserGithubApi {

    @GET("/users/{username}")
    fun user(@Path("username") username: String): Deferred<User>
}
