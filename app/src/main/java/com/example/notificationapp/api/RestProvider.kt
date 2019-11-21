package com.example.notificationapp.api

import android.widget.Toast
import android.widget.Toast.makeText
import com.example.notificationapp.NotificationApp
import com.example.notificationapp.data.MessageBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RestProvider {

    private val BASE_URL: String = "https://pushover.net"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    private val service = getRetrofit().create(PushoverApi::class.java)

    fun sendMessage(messageBody: MessageBody) {
        service.sendMessage(messageBody).enqueue(object : Callback<MessageBody> {
            override fun onFailure(call: Call<MessageBody>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MessageBody>, response: Response<MessageBody>) {
                if (response.isSuccessful && response.body() != null) {
                    makeText(NotificationApp.context, "response is $response", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}

