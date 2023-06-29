package com.example.activity_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var editTextMail: TextView
    private lateinit var passTV: TextView
    private lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        editTextMail = findViewById(R.id.editTextMail)
        passTV = findViewById(R.id.editTextPassword)
        btn = findViewById(R.id.appCompatButton)

        btn.setOnClickListener {
            val email = editTextMail.text.toString()
            val password = passTV.text.toString()
            if (email != "" && password != "") {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        Log.d("denis", "3")
                        if (task.isSuccessful) {
                            val user = auth.currentUser
                            val intent = Intent(this, TasksActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "Введите корректный пароль и адрес электронной почты", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
            else {
                Toast.makeText(this, "Введите корректный пароль и адрес электронной почты", Toast.LENGTH_SHORT).show()
            }
        }
    }
}