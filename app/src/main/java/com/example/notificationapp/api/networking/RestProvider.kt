package com.example.notificationapp.api.networking

import com.example.notificationapp.NotificationApp.Companion.context
import com.example.notificationapp.api.services.PushoverApi
import com.example.notificationapp.data.model.Notification
import com.example.notificationapp.utils.extensions.toast
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class RestProvider {

    private val BASE_URL: String = "https://api.pushover.net"

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

    fun sendMessage(notification: Notification, onResult: (Notification) -> Unit) {
        service.sendMessage(
            notification.token,
            notification.user,
            notification.message,
            notification.title,
            notification.device
        ).enqueue(object : Callback<Notification> {
            override fun onFailure(call: Call<Notification>, t: Throwable) {
                t.printStackTrace()
                context.toast("ERROR")
            }

            override fun onResponse(
                call: Call<Notification>,
                response: Response<Notification>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    context.toast("notification will come now")
                    onResult(notification)
                }
            }
            private fun responseSuccess(){

            }
        })
    }

}

