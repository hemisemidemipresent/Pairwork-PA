package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val chpsList = ArrayList<Chapters>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        chpsList.add(Chapters("Mashed Potatoes", "\$6.00\nCreamy, buttery mashed potatoes", R.drawable.food01))
        chpsList.add(Chapters("Fish and Chips", "\$14.00\nCrispy battered fish and chips", R.drawable.food02))
        chpsList.add(Chapters("Pasta", "\$12.00\nFusilli in tomato sauce with ham and peppers", R.drawable.food03))
        chpsList.add(Chapters("Chocolate Cake", "\$8.00\nIndulgent chocolate fudge cake", R.drawable.food04))
        chpsList.add(Chapters("Espresso", "\$4.00\nSmooth and fragrant espresso", R.drawable.food05))
        val adapter = RecyclerAdapter(chpsList)
        recyclerView.setAdapter(adapter)
    }
}