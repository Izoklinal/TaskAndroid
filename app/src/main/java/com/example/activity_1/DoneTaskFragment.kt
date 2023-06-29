package com.example.activity_1

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.Date

class DoneTaskFragment(list: List<Task> = emptyList()) : Fragment() {
    val listRv = list
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rv: RecyclerView = view.findViewById(R.id.recyclerView_doneTasks)
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = RVDoneTasksAdapter(listRv)

        val user = FirebaseAuth.getInstance().currentUser
        val data = mutableListOf<Task>()
        val database = FirebaseDatabase.getInstance()
        val tasksRef = database.getReference("users/${user!!.uid}/tasks")
        tasksRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                data.clear()
                for (taskSnapshot in dataSnapshot.children) {
                    val task = taskSnapshot.getValue(Task::class.java)
                    if (task!!.status == 1) {
                        task.let { data.add(it) }
                    }
                }
                rv.adapter?.notifyDataSetChanged()
            }
            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("firebase", "Error getting data", databaseError.toException())
            }
        })
        rv.adapter = RVDoneTasksAdapter(data)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_done_task, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = DoneTaskFragment()
    }
}