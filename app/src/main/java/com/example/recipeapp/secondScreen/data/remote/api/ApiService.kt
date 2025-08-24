package com.example.recipeapp.secondScreen.data.remote.api

import com.example.recipeapp.core.data.Api.retrofitinit
import com.example.recipeapp.secondScreen.data.DTO.FoodDTO
import com.example.recipeapp.secondScreen.domain.mapper.toFoodUI
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("filter.php")
    suspend fun getByArea(@Query("a") area: String): FoodDTO

    @GET("filter.php")
    suspend fun getByCategory(@Query("c") category: String): FoodDTO
}

object RetrofitClient{
    val retrfitservice= retrofitinit.create(ApiService::class.java)
}


