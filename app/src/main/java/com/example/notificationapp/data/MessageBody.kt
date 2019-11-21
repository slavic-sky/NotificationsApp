package com.example.notificationapp.data

import com.squareup.moshi.Json

data class MessageBody(
    @field:Json(name = "token")
    val token: String? = null,
    @field:Json(name = "user")
    val user: String? = null,
    @field:Json(name = "message")
    var message: String? = null,
    @field:Json(name = "device")
    val device: String? = null,
    @field:Json(name = "title")
    var title: String? = null
)