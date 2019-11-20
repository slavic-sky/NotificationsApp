package com.example.notificationapp.api

import com.example.notificationapp.data.MessageBody
import java.util.*

object RepositoryProvider {

    private val retrofitClient = RestProvider()

    fun sendMessage(messageBody: MessageBody) = retrofitClient.sendMessage(messageBody)

    fun sendMessageToDate(messageBody: MessageBody, date: Date) {
        val currentDate = Date()
        if (currentDate == date){
            sendMessage(messageBody)
        }
    }
}