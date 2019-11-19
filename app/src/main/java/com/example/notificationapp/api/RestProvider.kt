package com.example.notificationapp.api

import com.example.notificationapp.data.MessageBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val API_KEY = "a8qnicp2ny9edeptyjcfxr1uxekfqa"
private const val USER_KEY = "ufatpynukrwdd3ved6ffv5f54p114g"
private const val DEVICE_NAME = "device_real"

class RestProvider {

    private val BASE_URL: String = "https://pushover.net"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    private var messageBody = MessageBody(
        token = API_KEY,
        user = USER_KEY,
        device = DEVICE_NAME
    )

    private val service = getRetrofit().create(PushoverApi::class.java)

    fun sendMessage(messageBody: MessageBody) {
        service.sendMessage(messageBody).enqueue(object : Callback<MessageBody> {
            override fun onFailure(call: Call<MessageBody>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MessageBody>, response: Response<MessageBody>) {
                if (response.isSuccessful && response.body() != null) {

                }
            }
        })
    }
}

