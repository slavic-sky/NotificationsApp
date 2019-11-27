package com.example.notificationapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.notificationapp.data.model.Notification
import java.util.Calendar

@Entity(
    tableName = "notifications",
    foreignKeys = [
        ForeignKey(
            entity = NotificationEntity::class,
            parentColumns = ["id"],
            childColumns = ["post_id"]
        )
    ],
    indices = [Index("post_id")]
)
data class NotificationEntity(
    @ColumnInfo(name = "date_to_send") val postDate: Calendar = Calendar.getInstance(),

    @ColumnInfo(name = "message") val postMessage: String,

    @ColumnInfo(name = "title") val postTitle: String

) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var notificationId: Long = 0
}