package com.example.notificationapp.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notificationapp.R
import com.example.notificationapp.domain.model.NotificationMessage

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val titleView: TextView = itemView.findViewById(R.id.tv_notif_title)
    private val messageView: TextView = itemView.findViewById(R.id.tv_notif_message)
    private val dateView: TextView = itemView.findViewById(R.id.tv_notif_date_time)

    fun bindView(entity: NotificationMessage, date: String) {
        val message: String = entity.message
        val title: String? = entity.title
        val date: String = date
        titleView.text = title
        messageView.text = message
        dateView.text = date
    }
}