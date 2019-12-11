package com.example.notificationapp.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

@Module(includes = [ContextModule::class])
class OkHttpClientModule{

    @Provides
    fun okHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor?
    ): OkHttpClient? {
        return OkHttpClient()
            .newBuilder()
            .addInterceptor(httpLoggingInterceptor!!)
            .build()
    }

    @Provides
    fun httpLoggingInterceptor(): HttpLoggingInterceptor? {
        val httpLoggingInterceptor =
            HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    Timber.d(message)
                }
            })
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
        return httpLoggingInterceptor
    }
}