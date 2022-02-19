package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import com.example.myapplication.R

class AddReviewActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var editTextReview: EditText
    lateinit var ratingBar: RatingBar

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_review)
        button = findViewById(R.id.submitReviewButton)
        editTextReview = findViewById(R.id.editTextReview)
        ratingBar = findViewById(R.id.ratingBar2)
        ratingBar.numStars = 5
        ratingBar.stepSize = 0.5f

        button.setOnClickListener { view ->
            val intent = Intent(this, ReviewActivity::class.java)
            intent.putExtra("newReview", true)
            intent.putExtra("rating", ratingBar.rating.toString())
            intent.putExtra("review", editTextReview.text.toString())
            this.startActivity(intent)
        }
    }

}