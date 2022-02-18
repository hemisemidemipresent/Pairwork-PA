package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*
import kotlin.collections.ArrayList

class ReviewActivity : AppCompatActivity() {
    val reviewList = ArrayList<Review>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        reviewList.add(
            Review(
                5.0,
                "um",
                R.drawable.food02,
                "Dummy Rating"
            )
        )
        reviewList.add(
            Review(
                4.5,
                "ur mother",
                R.drawable.food05,
                "Dummy Rating 2"
            )
        )
        reviewList.add(
            Review(
                0.0,
                "L",
                R.drawable.ic_launcher_foreground,
                "a a a a a"
            )
        )
        val adapter = ReviewRecyclerAdapter(reviewList)
        recyclerView.adapter = adapter

        fab.setOnClickListener { view ->
            val intent = Intent(this, AddReviewActivity::class.java)
            this.startActivity(intent)
        }
    }
}
