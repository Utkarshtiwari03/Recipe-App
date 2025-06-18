package com.example.recipeapp.secondScreen.domain.mapper

import com.example.recipeapp.secondScreen.data.DTO.FoodDTO
import com.example.recipeapp.secondScreen.domain.model.FoodUI

fun FoodDTO.toFoodUI(): List<FoodUI>{
    return meals.map { detail->
        FoodUI(
            idMeal = detail.idMeal,
            strMeal = detail.strMeal,
            strMealThumb = detail.strMealThumb
        )
    }
}