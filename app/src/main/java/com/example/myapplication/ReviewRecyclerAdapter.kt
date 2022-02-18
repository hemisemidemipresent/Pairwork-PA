package com.example.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class ReviewRecyclerAdapter(val reviewList: ArrayList<Review>) :
    RecyclerView.Adapter<ReviewRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.review_card_layout, parent, false)
        return ViewHolder(v, reviewList)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(reviewList[position])
    }

    override fun getItemCount() = reviewList.size
    class ViewHolder(itemView: View, val reviewList: ArrayList<Review>) :
        RecyclerView.ViewHolder(itemView) {
        var reviewAvatar: ImageView
        var reviewer: TextView
        var reviewRating: RatingBar

        init {
            reviewAvatar = itemView.findViewById(R.id.avatar)
            reviewer = itemView.findViewById(R.id.name)
            reviewRating = itemView.findViewById(R.id.ratingBar)
            itemView.setOnClickListener { view ->
                val review = reviewList[adapterPosition]
                val intent = Intent(itemView.context, DescriptionActivity::class.java)
                intent.putExtra("avatar", review.avatar)
                intent.putExtra("name", review.name)
                intent.putExtra("rating", review.rating)
                intent.putExtra("review", review.review)
                //itemView.context.startActivity(intent)
            }
        }

        fun bindItems(review: Review) {
            reviewRating.rating = review.rating.toFloat()
            reviewRating.setIsIndicator(true)
            reviewer.text = review.name
            reviewAvatar.setImageResource(review.avatar)
        }
    }
}
