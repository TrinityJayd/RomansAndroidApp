package com.trinityjayd.romans

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OriginalPizzasActivity : AppCompatActivity() {

    private lateinit var pizzaApiService: PizzaApiService
    private lateinit var pizzaTypesAdapter: PizzaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_original_pizzas)


        val retrofit = Retrofit.Builder()
            .baseUrl("http://localhost:5182/pizza/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        pizzaApiService = retrofit.create(PizzaApiService::class.java)

        val pizzaTypesRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        pizzaTypesRecyclerView.layoutManager = LinearLayoutManager(this)
        pizzaTypesAdapter = PizzaAdapter(listOf())
        pizzaTypesRecyclerView.adapter = pizzaTypesAdapter

        // Call the getPizzaTypes() function using Kotlin coroutines
        GlobalScope.launch {
            try {
                val pizzaTypes = pizzaApiService.getPizzaTypes()
                runOnUiThread {
                    pizzaTypesAdapter = PizzaAdapter(pizzaTypes)
                    pizzaTypesRecyclerView.adapter = pizzaTypesAdapter
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }


    }


}