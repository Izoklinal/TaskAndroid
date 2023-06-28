package com.example.activity_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.activity_1.databinding.ActivityTasksBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import java.util.Date

class TasksActivity : AppCompatActivity() {
    private val fragList = listOf(
        PresentTaskFragment.newInstance(),
        DoneTaskFragment.newInstance()
    )
    private lateinit var binding: ActivityTasksBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTasksBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.placeHolder, fragList[0])
            .commit()

        binding.tabTasks.addOnTabSelectedListener(object : OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.placeHolder, fragList[tab?.position!!])
                    .commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }
}