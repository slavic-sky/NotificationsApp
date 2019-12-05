package com.example.notificationapp.utils

import android.content.Context
import com.example.notificationapp.data.AppDatabase
import com.example.notificationapp.data.NotificationRepository
import com.example.notificationapp.viewmodel.PostsViewModelFactory

/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 */
/*object InjectorUtils {

    fun providePostsViewModelFactory(context: Context): PostsViewModelFactory {
        val repository = getPostsRepository(context)
        return PostsViewModelFactory(repository)
    }

    private fun getPostsRepository(context: Context): NotificationRepository {
        return NotificationRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).notificationDao())
    }
}*/
