package com.example.notificationapp.api.networking

import com.example.notificationapp.model.Notification

object RepositoryProvider {

    private val retrofitClient =
        RestProvider()

    fun sendMessage(notification: Notification, onResult: (Notification) -> Unit) {
        retrofitClient.sendMessage(notification, onResult)
    }

/*    fun sendMessageToDate(notificationBody: NotificationBody, date: Date) {
        val currentDate = Date()
        if (currentDate == date) {
            sendMessage(notificationBody, (NotificationBody)-> Unit)
        }*/
}