package com.example.notificationapp.modules

import com.example.notificationapp.data.api.networking.PushoverApi
import com.example.notificationapp.utils.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module(includes = [OkHttpClientModule::class])
class NotificationsModule {

    @Provides
    fun retrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    fun pushoverApi(retrofit: Retrofit): PushoverApi {
        return retrofit.create(PushoverApi::class.java)
    }
}