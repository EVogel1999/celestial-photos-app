package com.example.final_project.ui.notifications

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.final_project.R
import com.example.final_project.model.Notification


class NotificationRecyclerAdapter(val notifications: List<Notification>) : RecyclerView.Adapter<NotificationRecyclerAdapter.NotificationHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotificationHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notification_list_view, parent, false)
        return NotificationHolder(view)
    }

    override fun getItemCount(): Int {
        return notifications.size
    }

    override fun onBindViewHolder(
        holder: NotificationHolder,
        position: Int
    ) {
        val notification = notifications[position]
        holder.type.text = notification.messageType
        holder.time.text = notification.messageIssueTime
        holder.url = notification.messageURL
    }

    class NotificationHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        var url = ""
        val type = v.findViewById<TextView>(R.id.notificationTypeTV)
        val time = v.findViewById<TextView>(R.id.notificationTimeTV)

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            startActivity(v.context, Intent(Intent.ACTION_VIEW, Uri.parse(url)), null)
        }
    }
}