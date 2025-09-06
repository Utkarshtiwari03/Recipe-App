package com.example.recipeapp.FirstScreen.data.Api

import com.example.recipeapp.core.data.Api.retrofitinit
import com.example.recipeapp.FirstScreen.data.DTO.Area.AreaDTO
import com.example.recipeapp.FirstScreen.data.DTO.category.CategoryDTO
import com.example.recipeapp.FirstScreen.domain.mapper.toAreaUI
import com.example.recipeapp.FirstScreen.domain.mapper.toAreaUIC
import retrofit2.http.GET

interface ApiService {
    @GET("list.php?a=list")
    suspend fun getArea(): AreaDTO

    @GET("list.php?c=list")
    suspend fun getCategory(): CategoryDTO
}

object ApiClient{
    val apiRetrofitClient= retrofitinit.create(ApiService::class.java)
}

//suspend fun main(){
//    println(ApiClient.apiRetrofitClient.getArea().toAreaUI())
//    print(ApiClient.apiRetrofitClient.getCategory().toAreaUIC())
//}
