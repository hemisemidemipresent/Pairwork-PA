package com.example.myapplication

import java.util.*

data class Item(
    val ID: String,
    val name: String,
    val desc: String,
    val brand: String,
    val price: Double,
    val size: ItemSize,
    val expiry: Date,
    val img: Int,
    val temp: Int,
)
