package com.example.notificationapp.di.modules

import android.content.Context
import com.example.notificationapp.interfaces.ApplicationContext
import com.example.notificationapp.interfaces.PostApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ContextModule(var context: Context) {
    @ApplicationContext
    @PostApplicationScope
    @Provides
    fun context(): Context {
        return context.applicationContext
    }

}
