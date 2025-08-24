package com.example.recipeapp.secondScreen.data.repositoryImpl

import com.example.recipeapp.secondScreen.data.remote.api.RetrofitClient
import com.example.recipeapp.secondScreen.domain.mapper.toFoodUI
import com.example.recipeapp.secondScreen.domain.model.FoodUI
import com.example.recipeapp.secondScreen.domain.repopsitory.Repository2
import java.util.Locale

class RepositoryImpl2(): Repository2{
    override suspend fun getData(region: String, category: String): List<FoodUI> {
        if (category.isNotEmpty()) {
            return RetrofitClient.retrfitservice.getByCategory(category).toFoodUI()
        }
        else{
            return RetrofitClient.retrfitservice.getByArea(region).toFoodUI()
        }
    }
}
//
//suspend fun main(){
//    println(RetrofitClient.retrfitservice.getByArea("American").toFoodUI() )
//    println(RetrofitClient.retrfitservice.getByCategory("Breakfast").toFoodUI())
//}

