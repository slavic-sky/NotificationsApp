package com.example.notificationapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notificationapp.data.NotificationRepository
import com.example.notificationapp.data.model.NotificationMessage

class PostsViewModel(notificationRepository: NotificationRepository) : ViewModel()  {

    private val postLiveData = MutableLiveData<NotificationMessage>()
    private val postsListLiveData = MutableLiveData<MutableList<NotificationMessage>>()

    fun getPostsLiveData() = postLiveData
    fun getPostsListLiveData() = postsListLiveData
}