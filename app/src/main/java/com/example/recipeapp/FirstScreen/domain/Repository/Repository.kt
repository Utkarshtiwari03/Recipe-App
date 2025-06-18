package com.example.recipeapp.FirstScreen.domain.Repository

import com.example.recipeapp.FirstScreen.domain.model.AreaUI

interface Repository {

    suspend fun getAreaName():List<AreaUI>
}
