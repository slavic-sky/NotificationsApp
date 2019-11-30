package com.example.notificationapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notificationapp.data.NotificationRepository

/**
 * Factory for creating a [PostsViewModel] with a constructor that takes a [NotificationRepository].
 */
class PostsViewModelFactory(
    private val repository: NotificationRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = PostsViewModel(repository) as T
}
