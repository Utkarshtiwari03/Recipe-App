package com.example.recipeapp.FirstScreen.presentation

import com.example.recipeapp.FirstScreen.domain.model.AreaUI
import com.example.recipeapp.FirstScreen.domain.model.CategoryUI

data class StartScreenState(
    val isLoading: Boolean=true,
    val areaList: List<AreaUI> =emptyList(),
    val categoryList:List<CategoryUI> =emptyList()
)
