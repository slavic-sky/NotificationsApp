package com.example.notificationapp.api

import com.example.notificationapp.NotificationApp.Companion.context
import com.example.notificationapp.data.MessageBody
import com.example.notificationapp.utils.extensions.toast
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class RestProvider {

    private val BASE_URL: String = "https://pushover.net"

    private fun getRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client.build())
            .build()
    }

    private val service = getRetrofit().create(PushoverApi::class.java)

    fun sendMessage(messageBody: MessageBody) {
        println("==============================" + messageBody)
        service.sendMessage(
            messageBody.token,
            messageBody.user,
            messageBody.message,
            messageBody.title,
            messageBody.device
        ).enqueue(object : Callback<MessageBody> {
            override fun onFailure(call: Call<MessageBody>, t: Throwable) {
                t.printStackTrace()
                context.toast("ERROR")
            }

            override fun onResponse(call: Call<MessageBody>, response: Response<MessageBody>) {
                if (response.isSuccessful && response.body() != null) {
                    context.toast("RESPONSE")
                }
            }
        })
    }
}

