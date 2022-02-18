package com.example.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class RecyclerAdapter(val chpsList: ArrayList<Item>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v, chpsList)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(chpsList[position])
    }

    override fun getItemCount() = chpsList.size
    class ViewHolder(itemView: View, val chpsList: ArrayList<Item>) :
        RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemName: TextView
        var itemDescription: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemName = itemView.findViewById(R.id.item_name)
            itemDescription = itemView.findViewById(R.id.item_description)
            itemView.setOnClickListener { view ->
                val pos = adapterPosition + 1
                val item = chpsList[adapterPosition]
                // fuck you
                // unsnacks your snackbar
                // Snackbar.make(view, "Click detected on item $pos", Snackbar.LENGTH_LONG)
                //      .setAction("Action", null).show()
                val intent = Intent(itemView.context, DescriptionActivity::class.java)
                intent.putExtra("ID", item.ID)
                intent.putExtra("name", item.name)
                intent.putExtra("desc", item.desc)
                intent.putExtra("brand", item.brand)
                intent.putExtra("price", item.price)

                when (item.size) {
                    ItemSize.LARGE -> {
                        intent.putExtra("size", "large")
                    }
                    ItemSize.MEDIUM -> {
                        intent.putExtra("size", "medium")
                    }
                    ItemSize.SMALL -> {
                        intent.putExtra("size", "small")
                    }
                }
                intent.putExtra("expiry", item.expiry.time)
                intent.putExtra("img", item.img)
                intent.putExtra("temp",item.temp)
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
