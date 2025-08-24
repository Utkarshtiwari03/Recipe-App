package com.example.recipeapp.FirstScreen.domain.Repository

import com.example.recipeapp.FirstScreen.domain.model.AreaUI
import com.example.recipeapp.FirstScreen.domain.model.CategoryUI

interface Repository {

    suspend fun getAreaName():List<AreaUI>
    suspend fun getCategoryName():List<CategoryUI>
}
