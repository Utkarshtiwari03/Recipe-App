package com.example.recipeapp.thirdScreen.presentation

import com.example.recipeapp.thirdScreen.domain.model.RecipeUI

data class State3(
    val isLoading:Boolean=true,
    val RecipeList:List<RecipeUI> =emptyList()
)
