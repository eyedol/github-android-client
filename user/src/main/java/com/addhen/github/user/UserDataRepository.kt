package com.addhen.github.users

import com.addhen.github.user.UserGithubApi
import com.addhen.github.user.UserRepository
import com.addhen.github.user.model.User
import javax.inject.Inject

class UserDataRepository @Inject constructor(
    private val githubApi: UserGithubApi
) : UserRepository {

    override suspend fun user(username: String): User = githubApi.user(username).await()
}
