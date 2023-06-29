package com.example.activity_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Date

class DoneTaskFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rv: RecyclerView = view.findViewById(R.id.recyclerView_doneTasks)
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = RVDoneTasksAdapter(fillList())
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_done_task, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = DoneTaskFragment()
    }
    private fun fillList(): List<Task> {
        val data = mutableListOf<Task>()
        data.add(0, Task("Название", "Описание", Date(2023, 12, 12), true, Date(2023,12,13)))
        data.add(1, Task("фвпыва", "ываапыва", Date(2023, 12, 12), false, Date(2023,12,13)))
        data.add(2, Task("аапывап", "икыеиапи", Date(2023, 12, 12), true, Date(2023,12,13)))
        data.add(3, Task("йцукпыва", "квенвачц", Date(2023, 12, 12), false, Date(2023,12,13)))
        data.add(4, Task("укпыва", "Описеыкеваание", Date(2023, 12, 12), true, Date(2023,12,13)))
        return data
    }
}