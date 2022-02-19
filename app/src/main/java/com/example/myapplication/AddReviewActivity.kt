package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import com.google.android.material.snackbar.Snackbar

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
            val ratingVal = ratingBar.rating
            val review = editTextReview.text.toString()
            if (review.isEmpty()) {
                Snackbar.make(view, "You have not put in a review", Snackbar.LENGTH_LONG)
                    .show()
            } else if (ratingVal == 0.0F) {
                Snackbar.make(view, "You have not put in your rating", Snackbar.LENGTH_LONG)
                    .show()
            } else {
                val intent = Intent(this, ReviewActivity::class.java)
                intent.putExtra("newReview", true)
                intent.putExtra("rating", ratingBar.rating.toString())
                intent.putExtra("review", editTextReview.text.toString())
                this.startActivity(intent)
            }

        }
    }

}