package com.example.recipeapp.secondScreen.data.repositoryImpl

import com.example.recipeapp.secondScreen.data.remote.api.RetrofitClient
import com.example.recipeapp.secondScreen.domain.mapper.toFoodUI
import com.example.recipeapp.secondScreen.domain.model.FoodUI
import com.example.recipeapp.secondScreen.domain.repopsitory.Repository2

class RepositoryImpl2(): Repository2{
    override suspend fun getData(region: String): List<FoodUI> {
       return RetrofitClient.retrfitservice.getRecipe(region).toFoodUI()
    }
}

