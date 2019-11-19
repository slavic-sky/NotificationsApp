package com.example.notificationapp.data

import com.squareup.moshi.Json

data class MessageBody(
    @field:Json(name = "token")
    val token: String? = null,
    @field:Json(name = "user")
    val user: String? = null,
    @field:Json(name = "message")
    val message: String? = null,
    @field:Json(name = "device")
    val device: String? = null,
    @field:Json(name = "title")
    val title: String? = null
)