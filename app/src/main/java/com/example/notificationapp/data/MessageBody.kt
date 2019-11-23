package com.example.notificationapp.data

import com.example.notificationapp.BuildConfig
import com.squareup.moshi.Json

data class MessageBody(
    val token: String = BuildConfig.API_KEY,
    val user: String = BuildConfig.USER_KEY,
    var message: String = "",
    val device: String? = BuildConfig.DEVICE_NAME,
    var title: String? = null
)