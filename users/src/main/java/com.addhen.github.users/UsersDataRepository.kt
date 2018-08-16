package com.addhen.github.users

import com.addhen.github.user.model.User
import javax.inject.Inject

class UsersDataRepository @Inject constructor(
    private val githubApi: UsersGithubApi
) : UsersRepository {

    override suspend fun users(): List<User> = githubApi.users().await()
}
