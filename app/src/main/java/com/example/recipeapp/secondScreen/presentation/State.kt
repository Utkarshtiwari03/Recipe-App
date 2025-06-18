package com.example.recipeapp.secondScreen.presentation

import com.example.recipeapp.secondScreen.domain.model.FoodUI

data class State(
    val isLoading:Boolean=true,
    val foodList:List<FoodUI> = emptyList()
)
