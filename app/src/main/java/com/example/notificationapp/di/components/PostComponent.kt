package com.example.notificationapp.di.components

import com.example.notificationapp.di.modules.NotificationsModule
import com.example.notificationapp.interfaces.PostApplicationScope
import dagger.Component

@PostApplicationScope
@Component(modules = [NotificationsModule::class])
interface PostComponent {
    val notificationsService: NotificationsModule?
}
