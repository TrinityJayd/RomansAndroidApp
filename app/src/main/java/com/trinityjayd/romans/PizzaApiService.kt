package com.trinityjayd.romans

import retrofit2.http.GET

interface PizzaApiService {
    @GET("types")
    suspend fun getPizzaTypes(): List<String>

    @GET("toppings")
    suspend fun getPizzaToppings(): List<String>
}
