package com.example.notificationapp.data.api.networking

import com.example.notificationapp.NotificationApp.Companion.context
import com.example.notificationapp.data.api.networking.RepositoryProvider.responseSuccess
import com.example.notificationapp.data.api.services.PushoverApi
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

    private fun getRetrofit(): PushoverApi {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client.build())
            .build()
            .create(PushoverApi::class.java)
    }

    private val service = getRetrofit()

    fun sendMessage(notification: Notification) {
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
                    responseSuccess()
                }
            }
        })
    }
}

