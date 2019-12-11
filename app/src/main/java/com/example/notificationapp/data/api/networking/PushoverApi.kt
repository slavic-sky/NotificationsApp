package com.example.notificationapp.data.api.networking

import com.example.notificationapp.data.db.ResponseWrapper
import com.example.notificationapp.domain.model.NotificationMessage
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
    ): ResponseWrapper<NotificationMessage>
}