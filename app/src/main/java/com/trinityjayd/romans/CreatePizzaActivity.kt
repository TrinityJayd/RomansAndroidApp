package com.trinityjayd.romans

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CreatePizzaActivity : AppCompatActivity() {

    private lateinit var pizzaApiService: PizzaApiService
    private lateinit var customPizzaAdapter: CustomPizzaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_pizza)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://romans.azurewebsites.net/custompizza/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        pizzaApiService = retrofit.create(PizzaApiService::class.java)

        val customPizzaRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        customPizzaRecyclerView.layoutManager = LinearLayoutManager(this)
        customPizzaAdapter = CustomPizzaAdapter(listOf())
        customPizzaRecyclerView.adapter = customPizzaAdapter

        // Call the getPizzaTypes() function using Kotlin coroutines
        GlobalScope.launch {
            try {
                val pizzaTypes = pizzaApiService.getPizzaToppings()
                runOnUiThread {
                    customPizzaAdapter = CustomPizzaAdapter(pizzaTypes)
                    customPizzaRecyclerView.adapter = customPizzaAdapter
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}