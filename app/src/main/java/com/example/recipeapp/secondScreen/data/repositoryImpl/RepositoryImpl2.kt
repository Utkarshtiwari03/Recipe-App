package com.example.recipeapp.secondScreen.data.repositoryImpl

import android.util.Log
import com.example.recipeapp.secondScreen.data.remote.api.RetrofitClient
import com.example.recipeapp.secondScreen.domain.mapper.toFoodUI
import com.example.recipeapp.secondScreen.domain.model.FoodUI
import com.example.recipeapp.secondScreen.domain.repopsitory.Repository2
import java.util.Locale

class RepositoryImpl2(): Repository2{
    override suspend fun getData(region: String, category: String): List<FoodUI> {
        if (category.isNotEmpty()) {
            val response=RetrofitClient.retrfitservice.getByCategory(category).toFoodUI()
            Log.d("API", "Meals category received $category :  ${response}")
            return response
        }
        else{
            var reponse = RetrofitClient.retrfitservice.getByArea(region).toFoodUI()
            Log.d("API", "Meals area received $region : ${reponse}")
            return reponse
        }
    }
}
//
//suspend fun main(){
//    println(RetrofitClient.retrfitservice.getByArea("American").toFoodUI() )
//    println(RetrofitClient.retrfitservice.getByCategory("Breakfast").toFoodUI())
//}

