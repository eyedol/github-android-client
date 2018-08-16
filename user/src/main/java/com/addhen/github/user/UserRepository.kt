package com.addhen.github.user

import com.addhen.github.user.model.User

interface UserRepository {

    suspend fun user(username: String): User
}
