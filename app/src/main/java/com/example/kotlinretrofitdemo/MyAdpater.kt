package com.example.kotlinretrofitdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MyAdpater(val context: Context ,val userlist :List<MyDataItem>):
    RecyclerView.Adapter<MyAdpater.ViewHolder>() {
    class ViewHolder(itemView: View ):RecyclerView.ViewHolder(itemView) {

        var userId = TextView()
        var title = TextView()

        init {
            userId=itemView.findViewById<TextView>(R.id.userId)
            title=itemView.findViewById<TextView>(R.id.title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView=LayoutInflater.from(context).inflate(R.layout.row_items , parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userId= userlist[position].userId.toString()
        holder.title=userlist[position].title
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}