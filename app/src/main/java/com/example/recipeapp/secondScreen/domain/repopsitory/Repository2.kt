package com.example.recipeapp.secondScreen.domain.repopsitory

import com.example.recipeapp.secondScreen.domain.model.FoodUI

interface Repository2 {
    suspend fun getData(region: String, category: String):List<FoodUI>
}