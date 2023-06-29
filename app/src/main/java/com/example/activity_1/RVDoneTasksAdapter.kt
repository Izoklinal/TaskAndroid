package com.example.activity_1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVDoneTasksAdapter(val tasks: List<Task>) : RecyclerView.Adapter<RVDoneTasksAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.textNameDone)
        val desc: TextView = itemView.findViewById(R.id.textDescriptionDone)
        val status: TextView = itemView.findViewById(R.id.textStatus)
        val deadline: TextView = itemView.findViewById(R.id.textDate)
        val dateDone: TextView = itemView.findViewById(R.id.textViewDateDone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recyclerview_item_done, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = tasks[position].name
        holder.desc.text = tasks[position].desc
        holder.dateDone.text = tasks[position].dateDone.toString()
        holder.deadline.text = tasks[position].deadline.toString()
        holder.status.text = tasks[position].status.toString()

    }
}