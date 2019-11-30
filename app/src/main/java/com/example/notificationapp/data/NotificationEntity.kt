package com.example.notificationapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "notifications",
    indices = [Index("post_id")]
)
data class NotificationEntity(
    @ColumnInfo(name = "date_to_send") val date: Calendar = Calendar.getInstance(),
    @ColumnInfo(name = "message") val message: String,
    @ColumnInfo(name = "title") val title: String?

) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var notificationId: Long = 0
}