package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    val chpsList = ArrayList<Item>()
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        sharedPreferences = getSharedPreferences("Prefs", Context.MODE_PRIVATE)
        //val editor = sharedPreferences.edit()
        //editor.clear()
        //editor.apply()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = intent
        val isfromsignup = intent.getBooleanExtra("fromsignup", false)
        if (isfromsignup) {
            val username = sharedPreferences.getString("username", "oops")
            Snackbar.make(
                findViewById(R.id.fab),
                "$username, you have been signed up!",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        chpsList.add(
            Item(
                "FD00000",
                "apple",
                "an apple a day keeps the doctor away",
                "Pasar",
                2.0,
                ItemSize.SMALL,
                Date(1676385477),
                R.drawable.apple, 3
            )
        )
        chpsList.add(
            Item(
                "FD00001",
                "carrot",
                "everyone's favourite orange root",
                "Pasar",
                1.0,
                ItemSize.MEDIUM,
                Date(1676385477),
                R.drawable.carrot, 15
            )
        )
        chpsList.add(
            Item(
                "FD00002",
                "green tea",
                "green tea to drink",
                "Polka",
                1.5,
                ItemSize.MEDIUM,
                Date(1676385477),
                R.drawable.tea, 25
            )
        )
        val adapter = RecyclerAdapter(chpsList)
        recyclerView.adapter = adapter

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            @Suppress("NAME_SHADOWING") val intent = Intent(this, ContactActivity::class.java)
            this.startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will automatically handle clicks on
        // the Home/Up button, so long as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_info -> {
                val intent = Intent(this, AboutActivity::class.java)
                this.startActivity(intent)
                true
            }
            R.id.action_contact -> {
                val intent = Intent(this, ContactActivity::class.java)
                this.startActivity(intent)
                true
            }
            R.id.action_reviews -> {
                Toast.makeText(this, "rev", Toast.LENGTH_LONG).show()
                val intent = Intent(this, ReviewActivity::class.java)
                this.startActivity(intent)
                true
            }
            R.id.action_sign_up -> {
                // un-toasts your bread
                //Toast.makeText(this, "signup", Toast.LENGTH_LONG).show()
                val intent = Intent(this, SignUpActivity::class.java)
                this.startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}
