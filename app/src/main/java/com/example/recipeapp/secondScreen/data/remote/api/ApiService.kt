package com.example.recipeapp.secondScreen.data.remote.api

import com.example.recipeapp.core.data.Api.retrofitinit
import com.example.recipeapp.secondScreen.data.DTO.FoodDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("filter.php")
    suspend fun getRecipe(
        @Query("a") a: String
    ):FoodDTO
}

object RetrofitClient{
    val retrfitservice= retrofitinit.create(ApiService::class.java)
}
//suspend fun main() {
//    println(RetrofitClient.retrfitservice.getRecipe("indian"))
//}