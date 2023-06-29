package com.example.activity_1

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date

data class Task (var title: String = "",
            var description: String = "",
            var deadline: String = "",
            var dateDone: String? = "",
            var status: Int = 0)