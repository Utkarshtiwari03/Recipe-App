package com.example.recipeapp.FirstScreen.data.Api

import com.example.recipeapp.core.data.Api.retrofitinit
import com.example.recipeapp.FirstScreen.data.DTO.AreaDTO
import retrofit2.http.GET

interface ApiService {
    @GET("list.php?a=list")
    suspend fun getArea(): AreaDTO
}

object ApiClient{
    val apiRetrofitClient= retrofitinit.create(ApiService::class.java)
}

//suspend fun main(){
//    println("${ApiClient.apiRetrofitClient.getArea()}")
//}