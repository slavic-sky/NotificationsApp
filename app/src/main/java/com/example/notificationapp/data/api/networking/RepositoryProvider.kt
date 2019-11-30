package com.example.notificationapp.data.api.networking

import com.example.notificationapp.data.model.Notification

object RepositoryProvider {

    private val retrofitClient =
        RestProvider()

    fun sendMessage(notification: Notification) {
        retrofitClient.sendMessage(notification)
    }

/*    fun sendMessageToDate(notificationBody: NotificationBody, date: Date) {
        val currentDate = Date()
        if (currentDate == date) {
            sendMessage(notificationBody, (NotificationBody)-> Unit)
        }*/
}