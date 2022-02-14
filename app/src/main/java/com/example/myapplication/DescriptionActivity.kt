package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import java.util.*

class DescriptionActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        val intent = intent
        val string = intent.getStringExtra("string")

        val name: TextView = findViewById(R.id.name)
        val item_image: ImageView = findViewById(R.id.item_image)
        val desc: TextView = findViewById(R.id.desc)
        val price: TextView = findViewById(R.id.price)
        val size: TextView = findViewById(R.id.size)
        val expiry: TextView = findViewById(R.id.expiry)
        val brand: TextView = findViewById(R.id.brand)
        val temp: TextView = findViewById(R.id.temp)

        name.text = intent.getStringExtra("name")
        item_image.setImageResource(
            intent.getIntExtra(
                "img",
                R.drawable.food01
            )
        ) // replace with a 404 image
        desc.text = intent.getStringExtra("desc")
        price.text = "$" + intent.getDoubleExtra("price", 0.0)
        size.text = "size: " + intent.getStringExtra("size")

        val date = Date(intent.getLongExtra("expiry", 0))
        expiry.text = "expiry: " + date.toString()
        brand.text = "brand" + intent.getStringExtra("brand")
        temp.text = "Storage temperature: " + intent.getIntExtra("temp",404) + "°C"

    }

}
