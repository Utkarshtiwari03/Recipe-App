package com.example.recipeapp.thirdScreen.data.api

import com.example.recipeapp.core.data.Api.retrofitinit
import com.example.recipeapp.thirdScreen.data.DTO.RecipeDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search.php")
    suspend fun getRecipe(
        @Query("s") Food: String
    ): RecipeDTO
}

object ApiClient{
    val RetrofitClient3= retrofitinit.create(ApiService::class.java)
}