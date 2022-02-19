package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


class SignUpActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val btn = findViewById<Button>(R.id.button)
        val usernameEditText = findViewById<TextView>(R.id.username)
        val passwordEditText = findViewById<TextView>(R.id.password)
        val username = usernameEditText.text
        val password = passwordEditText.text
        sharedPreferences = getSharedPreferences("Prefs", Context.MODE_PRIVATE)
        btn.setOnClickListener { view ->

            if (username.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("fromsignup",true)
                val editor = sharedPreferences.edit()
                editor.putString("username", username.toString())
                editor.apply()
                this.startActivity(intent)
            } else if (username.isEmpty()) {
                Snackbar.make(view, "You have not put in a username", Snackbar.LENGTH_LONG)
                    .show()
            } else {
                Snackbar.make(view, "You have not put in a password", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}
