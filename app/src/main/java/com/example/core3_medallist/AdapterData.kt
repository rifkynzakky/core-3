package com.example.core3_medallist

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.core3_medallist.list

class AdapterData (val theList: MutableList<list>) : RecyclerView.Adapter<AdapterData.ViewHolder>() {

    // Call when an item is put into a screen
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterData.ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    // This is for the data calling
    override fun onBindViewHolder(holder: AdapterData.ViewHolder, position: Int) {
        val currentItem = theList[position]
        holder.bind(currentItem.country, currentItem.countryCode, currentItem.amount)

        if (position == 0) {
            holder.textViewCountry.setTextColor(Color.BLUE)
            holder.textViewCode.setTextColor(Color.BLUE)
            holder.textViewAmount.setTextColor(Color.BLUE)
        } else {
            holder.textViewCountry.setTextColor(Color.BLACK)
            holder.textViewCode.setTextColor(Color.BLACK)
            holder.textViewAmount.setTextColor(Color.BLACK)
        }
    }

    override fun getItemCount() = theList.size

    inner class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewCountry = itemView.findViewById<TextView>(R.id.text_country)
        val textViewCode = itemView.findViewById<TextView>(R.id.text_code)
        val textViewAmount = itemView.findViewById<TextView>(R.id.text_number)

        fun bind(country: String, code: String, amount: String) {
            textViewCountry.text = country
            textViewCode.text = code
            textViewAmount.text = amount

            itemView.setOnClickListener {
                Toast.makeText(
                    itemView.context,
                    theList[adapterPosition].country + " has won " + theList[adapterPosition].gold + " many gold medals",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

}