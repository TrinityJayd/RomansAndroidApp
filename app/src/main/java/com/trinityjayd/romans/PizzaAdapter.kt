package com.trinityjayd.romans

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PizzaAdapter(private val pizzaList: List<String>) :
    RecyclerView.Adapter<PizzaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pizzaNameTextView: TextView = itemView.findViewById(R.id.pizza_name)
        val orderButton: Button = itemView.findViewById(R.id.order_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pizza = pizzaList[position]
        holder.pizzaNameTextView.text = pizza

        holder.orderButton.setOnClickListener {
            // Handle click on order button
            // For example: orderPizza(pizza.id)
        }
    }

    override fun getItemCount(): Int {
        return pizzaList.size
    }
}
