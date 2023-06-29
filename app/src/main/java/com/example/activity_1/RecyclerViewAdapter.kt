package com.example.activity_1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(val tasks: List<Task>) :
RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTV: TextView = itemView.findViewById(R.id.textName)
        val descTV: TextView = itemView.findViewById(R.id.textDescription)
        val dateTV: TextView = itemView.findViewById(R.id.textViewDate)
        val btnStatus: Button = itemView.findViewById(R.id.btnComplete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recyclerview_element, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameTV.text = tasks[position].name
        holder.descTV.text = tasks[position].desc
        holder.dateTV.text = tasks[position].deadline.toString()
        changeBtn(position, holder)
        holder.btnStatus.setOnClickListener {
            tasks[position].status = tasks[position].status != true
            changeBtn(position, holder)
        }
    }
    fun changeBtn(position: Int, holder: MyViewHolder) {
        if (tasks[position].status == true) {
            holder.btnStatus.setBackgroundColor(Color.parseColor("#86DDFF"))
            holder.btnStatus.text = "Выполнено"
        }
        else {
            holder.btnStatus.setBackgroundColor(Color.parseColor("#00A9EC"))
            holder.btnStatus.text = "Отметить как выполненную"
        }
    }
}