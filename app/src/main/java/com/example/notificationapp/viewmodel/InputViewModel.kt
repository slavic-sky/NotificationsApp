package com.example.notificationapp.viewmodel

import android.app.Notification
import androidx.lifecycle.MutableLiveData
import com.example.notificationapp.data.api.networking.RepositoryProvider
import com.example.notificationapp.data.api.networking.RestProvider

class InputViewModel : BaseViewModel(){

        val simpleLiveData = MutableLiveData<Event<Notification>>()

    fun sendMessage(notification: Notification){
        requestWithLiveData(simpleLiveData){
            RepositoryProvider.sendMessage()
        }
    }
}
