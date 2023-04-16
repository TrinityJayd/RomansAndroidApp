package com.trinityjayd.romans

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomPizzaAdapter(private val toppingsList: List<String>) :
    RecyclerView.Adapter<CustomPizzaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val toppingName: TextView = itemView.findViewById(R.id.topping_name)
        val addButton: Button = itemView.findViewById(R.id.add_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.customitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pizza = toppingsList[position]
        holder.toppingName.text = pizza

        holder.addButton.setOnClickListener {
            // Handle click on order button
            // For example: orderPizza(pizza.id)
        }
    }

    override fun getItemCount(): Int {
        return toppingsList.size
    }
}
