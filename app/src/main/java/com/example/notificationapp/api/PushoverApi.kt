package com.example.notificationapp.api

import com.example.notificationapp.data.MessageBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

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