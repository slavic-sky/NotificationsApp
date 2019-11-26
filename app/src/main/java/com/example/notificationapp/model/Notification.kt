package com.example.notificationapp.model

import com.example.notificationapp.BuildConfig

data class Notification(
    val token: String = BuildConfig.API_KEY,
    val user: String = BuildConfig.USER_KEY,
    var message: String = "",
    val device: String? = BuildConfig.DEVICE_NAME,
    var title: String? = null
)