package com.example.myapplication

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.view.ViewGroup
import android.widget.ImageView
import android.view.LayoutInflater
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter(val chpsList: ArrayList<Chapters>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout,parent,false)
        return ViewHolder(v)

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(chpsList[position])
    }
    override fun getItemCount() = chpsList.size

    // The class holding the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemName: TextView
        var itemDescription: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemName = itemView.findViewById(R.id.item_name)
            itemDescription = itemView.findViewById(R.id.item_description)

            itemView.setOnClickListener{ view ->
                //val pos = adapterPosition +1
                /*val string = when(adapterPosition) {
                    0 -> "Mashed Potatoes\n\$6.00\nCreamy, buttery mashed potatoes"
                    1 -> "Fish and Chips\n\$14.00\nCrispy battered fish and chips"
                    2 -> "Pasta\n\$12.00\nFusilli in tomato sauce with ham and peppers"
                    3 -> "Chocolate Cake\n\$8.00\nIndulgent chocolate fudge cake"
                    4 -> "Espresso\n\$4.00\nSmooth and fragrant espresso"
                    else -> ""
                }
                Snackbar.make(view, "Click detected on item $pos", Snackbar.LENGTH_LONG)
                    .setAction("Action",null).show()*/
                //val intent = Intent(itemView.context, AfterActivity::class.java)
                //intent.putExtra("string", string)
                //itemView.context.startActivity(intent)
            }
        }

        fun bindItems(chp : Chapters){
            itemName.text = chp.title
            itemDescription.text = chp.detail
            itemImage.setImageResource(chp.images)
        }
    }
}
