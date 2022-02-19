package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.util.*
import kotlin.collections.ArrayList

class ReviewActivity : AppCompatActivity() {
    val reviewList = ArrayList<Review>()
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        val layoutManager = LinearLayoutManager(this)
        sharedPreferences = getSharedPreferences("Prefs", Context.MODE_PRIVATE)
        recyclerView.layoutManager = layoutManager
        reviewList.add(
            Review(
                5.0,
                "The app is...",
                R.drawable.food02,
                "Person 1"
            )
        )
        reviewList.add(
            Review(
                4.5,
                "The app is...",
                R.drawable.food05,
                "Person 2"
            )
        )
        reviewList.add(
            Review(
                5.0,
                "The app is...",
                R.drawable.ic_launcher_foreground,
                "Person 3"
            )
        )
        val intent = intent
        if (intent.getBooleanExtra("newReview", false)) {
            reviewList.add(
                Review(
                    intent.getStringExtra("rating")!!.toDouble(),
                    intent.getStringExtra("review").toString(),
                    R.drawable.ic_launcher_foreground,
                    sharedPreferences.getString("username", "oops").toString()
                )
            )
        }
        val adapter = ReviewRecyclerAdapter(reviewList)
        recyclerView.adapter = adapter

        fab.setOnClickListener { _ ->
            val username = sharedPreferences.getString("username", "oops")
            if (username.equals("oops")) {
                Snackbar.make(
                    findViewById(R.id.fab),
                    "Sign up before creating a review!",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
            else {
                @Suppress("NAME_SHADOWING") val intent = Intent(this, AddReviewActivity::class.java)
                this.startActivity(intent)
            }
        }
    }
}
