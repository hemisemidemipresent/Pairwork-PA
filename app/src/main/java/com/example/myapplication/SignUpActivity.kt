package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import com.google.android.material.snackbar.Snackbar

class SignUpActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val btn = findViewById<Button>(R.id.button)
        val usernameEditText = findViewById<TextView>(R.id.username)
        val passwordEditText = findViewById<TextView>(R.id.password)
        val username = usernameEditText.text
        val password = passwordEditText.text
        btn.setOnClickListener { view ->

            if (username.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("fromsignup",true)
                this.startActivity(intent)
            } else if (!username.isNotEmpty()) {
                Snackbar.make(view, "You have not put in a username", Snackbar.LENGTH_LONG)
                    .show()
            } else {
                Snackbar.make(view, "You have not put in a password", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}
