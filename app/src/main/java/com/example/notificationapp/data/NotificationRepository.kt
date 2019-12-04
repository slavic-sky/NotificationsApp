/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.notificationapp.data

import com.example.notificationapp.data.model.NotificationMessage

/**
 * Repository module for handling data operations.
 */
class NotificationRepository private constructor(private val postDao: NotificationDao) {

    fun getPosts() = postDao.getNotifications()

    suspend fun addPost(notificationMessage: NotificationMessage) {
        val notificationEntity = NotificationEntity(
            message = notificationMessage.message,
            title = notificationMessage.title
        )
        postDao.insertNotification(notificationEntity)
    }

    fun getPostById(postId: String) = postDao.getNotificationById(postId)

    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: NotificationRepository? = null

        fun getInstance(postDao: NotificationDao) =
            instance ?: synchronized(this) {
                instance ?: NotificationRepository(postDao).also { instance = it }
            }
    }
}
