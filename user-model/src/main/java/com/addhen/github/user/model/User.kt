package com.addhen.github.user.model

import com.squareup.moshi.Json

data class User(
    val id: Long,
    val name: String,
    val company: String,
    val bio: String,
    val location: String,
    @field:Json(name = "login") val username: String,
    @field:Json(name = "avatar_url") val avatarUrl: String
)
