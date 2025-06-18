package com.example.recipeapp.thirdScreen.data.RepositoryImpl

import com.example.recipeapp.thirdScreen.data.api.ApiClient
import com.example.recipeapp.thirdScreen.domain.Repository.Repository
import com.example.recipeapp.thirdScreen.domain.mapper.toRecipeUI
import com.example.recipeapp.thirdScreen.domain.model.RecipeUI

class RepositoryImpl: Repository {
    override suspend fun getRecipe(Food:String): List<RecipeUI> {
        return ApiClient.RetrofitClient3.getRecipe(Food).toRecipeUI()
    }

}

//suspend fun main() {
// println("hello ${ApiClient.RetrofitClient3.getRecipe("Dal Fry").meals}")
//}