package com.addhen.github.users

import com.addhen.github.user.model.User

interface UsersRepository {

    suspend fun users(): List<User>
}
