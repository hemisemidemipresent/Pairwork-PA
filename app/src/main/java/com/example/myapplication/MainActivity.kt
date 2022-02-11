package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    val chpsList = ArrayList<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        chpsList.add(Item("FD00000","name0","insert description","brand0",69420.0, ItemSize.MEDIUM, Date(0)))
        chpsList.add(Item("FD00001","name1","insert description","brand1",42069.0, ItemSize.SMALL, Date(1)))
        chpsList.add(Item("FD00002","name2","insert description","brand2",49062.0, ItemSize.MEDIUM, Date(2)))
        val adapter = RecyclerAdapter(chpsList)
        recyclerView.adapter = adapter
    }
}
