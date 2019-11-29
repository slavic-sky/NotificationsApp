package com.example.notificationapp.data.model

import android.provider.Settings.Global.DEVICE_NAME
import com.example.notificationapp.utils.API_KEY
import com.example.notificationapp.utils.USER_KEY

data class Notification(
    val token: String = API_KEY,
    val user: String = USER_KEY,
    var message: String = "",
    val device: String? = DEVICE_NAME,
    var title: String? = null
)