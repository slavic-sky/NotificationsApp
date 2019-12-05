package com.example.notificationapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.notificationapp.data.NotificationRepository
import com.example.notificationapp.data.api.networking.RestProvider
import com.example.notificationapp.data.model.NotificationMessage
import kotlinx.coroutines.launch

class PostsViewModel(private val notificationRepository: NotificationRepository) : BaseViewModel() {

    private val postLiveData = MutableLiveData<Event<NotificationMessage>>()
    private val service = RestProvider().getRetrofit()

    fun getPostsLiveData() = postLiveData

    fun sendMessage(post: NotificationMessage) {
        requestWithLiveData(postLiveData) {
            service.sendMessage(
                token = post.token,
                user = post.user,
                message = post.message,
                title = post.title,
                device = post.device
            )
        }
    }

    override fun responseSuccess(notificationMessage: NotificationMessage) {
        addPostToList(notificationMessage)
    }

    private fun addPostToList(notification: NotificationMessage){
        viewModelScope.launch {
            notificationRepository.addPost(notification)
        }
    }
}