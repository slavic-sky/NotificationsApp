package com.example.notificationapp.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notificationapp.R
import com.example.notificationapp.data.model.NotificationMessage
import com.example.notificationapp.view.viewholder.ViewHolder

class ListPostsAdapter : RecyclerView.Adapter<ViewHolder>() {

    private var postsList: MutableList<NotificationMessage> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.item_notification, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val messageBody = postsList[position]
        holder.bindView(messageBody, "")
    }

    fun loadNotification(notificationMessage: NotificationMessage?) {
        notificationMessage?.let { postsList.add(it) }
        notifyDataSetChanged()
    }
}