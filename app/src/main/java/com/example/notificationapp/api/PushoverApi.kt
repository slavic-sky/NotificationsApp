package com.example.notificationapp.api

import com.example.notificationapp.data.MessageBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

private val API_KEY = "a8qnicp2ny9edeptyjcfxr1uxekfqa"
private val USER_KEY = "uzhy6h56hb3ok79jpdkexbc8d83ggi"
private val DEVICE_NAME = "device_real"

interface PushoverApi {
    @POST("/1/messages.json")
    @FormUrlEncoded
    fun sendMessage(@Body messageBody : MessageBody) : Call<MessageBody>
}