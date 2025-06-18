package com.example.recipeapp.thirdScreen.domain.Repository

import com.example.recipeapp.thirdScreen.domain.model.RecipeUI

interface Repository {

    suspend fun getRecipe(Food:String):List<RecipeUI>
}