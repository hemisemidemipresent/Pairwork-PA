package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.R
import com.google.android.material.snackbar.Snackbar

class AddReviewActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_review)
        val editTextReview = findViewById<TextView>(R.id.editTextReview)
        val review = editTextReview.text;
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener { view ->

            if ( review.isNotEmpty()) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("fromsignup",true)
                this.startActivity(intent)
            } else if (false) {
                Snackbar.make(view, "You have not put in your rating", Snackbar.LENGTH_LONG)
                    .show()
            } else {
                Snackbar.make(view, "You have not put in a review", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }

}
