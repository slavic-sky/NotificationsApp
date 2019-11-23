package com.example.notificationapp.data

import com.example.notificationapp.BuildConfig
import com.squareup.moshi.Json

data class MessageBody(
    @field:Json(name = "token")
    val token: String = BuildConfig.API_KEY,
    @field:Json(name = "user")
    val user: String = BuildConfig.USER_KEY,
    @field:Json(name = "message")
    var message: String = "",
    @field:Json(name = "device")
    val device: String? = null,
    @field:Json(name = "title")
    var title: String? = BuildConfig.DEVICE_NAME
)