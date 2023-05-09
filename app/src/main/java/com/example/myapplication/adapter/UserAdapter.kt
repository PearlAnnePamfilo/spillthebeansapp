package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data_class.UsersItem

class UserAdapter (val context : Context, val userList : List<UsersItem>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    var onItemCLick : ((UsersItem) -> Unit)? = null

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var userName : TextView = itemView.findViewById(R.id.tv_allUserName)
        var userAge : TextView = itemView.findViewById(R.id.tv_allUserAge)
        var userEmail : TextView = itemView.findViewById(R.id.tv_allUserEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_coffee_users, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userPos = userList[position]
        holder.userName.text = userList[position].name
        holder.userAge.text = userList[position].phone
        holder.userEmail.text = userList[position].email


        holder.itemView.setOnClickListener {
            onItemCLick?.invoke(userPos)
        }
        }

    override fun getItemCount(): Int {
        return userList.count()
    }
}

