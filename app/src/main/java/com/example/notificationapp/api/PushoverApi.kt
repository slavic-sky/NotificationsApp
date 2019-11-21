package com.example.notificationapp.api

import com.example.notificationapp.data.MessageBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST



interface PushoverApi {
    @POST("/1/messages.json")
    fun sendMessage(@Body messageBody : MessageBody) : Call<MessageBody>
}