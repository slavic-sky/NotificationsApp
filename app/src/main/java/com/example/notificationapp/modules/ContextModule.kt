package com.example.notificationapp.modules

import android.content.Context
import com.example.notificationapp.interfaces.ApplicationContext
import com.example.notificationapp.interfaces.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ContextModule(var context: Context) {
    @ApplicationContext
    @ApplicationScope
    @Provides
    fun context(): Context {
        return context.applicationContext
    }

}
