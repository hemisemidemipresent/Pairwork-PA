package com.example.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter(val chpsList: ArrayList<Item>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(chpsList[position])
    }

    override fun getItemCount() = chpsList.size
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemName: TextView
        var itemDescription: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemName = itemView.findViewById(R.id.item_name)
            itemDescription = itemView.findViewById(R.id.item_description)
            itemView.setOnClickListener { view ->
                val pos = adapterPosition + 1
                Snackbar.make(view, "Click detected on item $pos", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
                val intent = Intent(itemView.context, DescriptionActivity::class.java)
                intent.putExtra("string", pos)
                itemView.context.startActivity(intent)
            }
        }

        fun bindItems(item: Item) {
            itemName.text = item.name
            itemDescription.text = item.desc
            itemImage.setImageResource(item.img)
        }
    }
}
