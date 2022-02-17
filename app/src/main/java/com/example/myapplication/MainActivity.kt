package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
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
        chpsList.add(
            Item(
                "FD00000",
                "name0",
                "insert description",
                "brand0",
                69420.0,
                ItemSize.MEDIUM,
                Date(1676385477),
                R.drawable.food03, -1
            )
        )
        chpsList.add(
            Item(
                "FD00001",
                "name1",
                "insert description",
                "brand1",
                42069.0,
                ItemSize.SMALL,
                Date(1676385477),
                R.drawable.food04, 69
            )
        )
        chpsList.add(
            Item(
                "FD00002",
                "name2",
                "insert description",
                "brand2",
                49062.0,
                ItemSize.MEDIUM,
                Date(1676385477),
                R.drawable.food05, 25
            )
        )
        val adapter = RecyclerAdapter(chpsList)
        recyclerView.adapter = adapter
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
                Toast.makeText(this, "info", Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_contact -> {
                Toast.makeText(this, "contact", Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_reviews -> {
                Toast.makeText(this, "rev", Toast.LENGTH_LONG).show()
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
