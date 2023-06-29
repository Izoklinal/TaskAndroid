package com.example.activity_1

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val data: List<Task> = emptyList()) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.textName)
        val descriptionTextView: TextView = itemView.findViewById(R.id.textDescription)
        val dateTextView: TextView = itemView.findViewById(R.id.textViewDate)
        val statusBtn: Button = itemView.findViewById(R.id.btnComplete)

        fun bind(task: Task) {
            titleTextView.text = task.title
            descriptionTextView.text = task.description
            dateTextView.text = task.deadline
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_element, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = data[position]
        holder.bind(task)
        holder.statusBtn.setOnClickListener {
            if (task.status != 1) {
                task.status = 1
                holder.statusBtn.setBackgroundColor(Color.parseColor("#86DDFF"))
                holder.statusBtn.text = "✓ Выполнено"
            }
            else {
                task.status = 0
                holder.statusBtn.setBackgroundColor(Color.parseColor("#00A9EC"))
                holder.statusBtn.text = "Отметить как выполненную"
            }
        }
        holder.bind(task)
    }

    override fun getItemCount(): Int {
        return data.size
    }


}