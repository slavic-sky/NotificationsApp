package com.example.notificationapp.api

import com.example.notificationapp.data.MessageBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.*

interface PushoverApi {
    @POST("/1/messages.json")
    @FormUrlEncoded
    fun sendMessage(
        @Field("token") token: String,
        @Field("user") user: String,
        @Field("message") message: String,
        @Field("title") title: String?,
        @Field("device") device: String?
    ): Call<MessageBody>
}