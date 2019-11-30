package com.example.notificationapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notificationapp.api.networking.RepositoryProvider
import com.example.notificationapp.data.NotificationRepository
import com.example.notificationapp.data.model.Notification
import kotlinx.coroutines.launch

class PostsViewModel(private val notificationRepository: NotificationRepository): ViewModel()  {

    private val postLiveData = MutableLiveData<Notification>()
    private val postsListLiveData = MutableLiveData<MutableList<Notification>>()

    fun getPostsLiveData() = postLiveData
    fun getPostsListLiveData() = postsListLiveData

    fun sendMessage(notification: Notification) {
        RepositoryProvider.sendMessage(notification){
            postLiveData.postValue(it)
        }
    }

    fun addPostToList(notification: Notification){
        viewModelScope.launch {
            notificationRepository.addPost(notification)
        }
    }
}