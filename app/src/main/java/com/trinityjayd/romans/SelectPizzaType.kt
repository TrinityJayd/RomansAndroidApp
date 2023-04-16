package com.trinityjayd.romans

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SelectPizzaType : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_pizza_type)

        val originalPizzasButton = findViewById<Button>(R.id.original_pizzas_button)
        val createPizzaButton = findViewById<Button>(R.id.create_pizza_button)

        originalPizzasButton.setOnClickListener {
            startActivity(Intent(this, OriginalPizzasActivity::class.java))
        }

        createPizzaButton.setOnClickListener {
             startActivity(Intent(this, CreatePizzaActivity::class.java))
        }

    }
}