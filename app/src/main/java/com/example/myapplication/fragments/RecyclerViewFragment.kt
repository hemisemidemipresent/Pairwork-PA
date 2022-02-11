package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Item
import com.example.myapplication.R
import com.example.myapplication.RecyclerAdapter

class RecyclerViewFragment : Fragment() {
    private val chpsList = ArrayList<Item>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_recycler_view, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val layoutManager = GridLayoutManager(view.context, 2)
        recyclerView.layoutManager = layoutManager
        //chpsList.add() // add Items (or whatever data class)
        val adapter = RecyclerAdapter(chpsList)
        recyclerView.adapter = adapter
        return view
    }
}
