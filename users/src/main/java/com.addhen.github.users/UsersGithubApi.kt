package com.addhen.github.users

import com.addhen.github.user.model.User
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET

interface UsersGithubApi {
    @GET("/users")
    fun users(): Deferred<List<User>>
}
