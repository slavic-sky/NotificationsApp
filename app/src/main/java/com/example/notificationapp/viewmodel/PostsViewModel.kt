package com.example.notificationapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notificationapp.api.networking.RepositoryProvider
import com.example.notificationapp.data.model.Notification

class PostsViewModel: ViewModel()  {

    private val postLiveData = MutableLiveData<Notification>()

    fun getPostsLiveData() = postLiveData

    fun sendMessage(notification: Notification) {
        RepositoryProvider.sendMessage(notification){
            postLiveData.postValue(it)
        }
    }
}