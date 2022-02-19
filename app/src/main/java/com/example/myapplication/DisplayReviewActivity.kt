package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import java.util.*

class DisplayReviewActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_review)
        val intent = intent

        val name: TextView = findViewById(R.id.name)
        val ratingBar: RatingBar = findViewById(R.id.rating)
        ratingBar.setIsIndicator(true)
        val review: TextView = findViewById(R.id.reviewTextView)
        val avatar: ImageView = findViewById(R.id.avatar)

        name.text = intent.getStringExtra("name")
        ratingBar.rating = (intent.getStringExtra("rating"))!!.toFloat()
        review.text = intent.getStringExtra("review")
        avatar.setImageDrawable(getDrawable(intent.getIntExtra("avatar",0)))
    }

}
