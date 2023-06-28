package com.example.activity_1

import java.util.Date

class Task(_name: String, _desc: String, _deadline: Date, _status: Boolean, _dateDone: Date? = null) {
    var name: String = _name
    var desc: String = _desc
    var deadline: Date = _deadline
    var dateDone: Date? = _deadline
    var status: Boolean = _status
}