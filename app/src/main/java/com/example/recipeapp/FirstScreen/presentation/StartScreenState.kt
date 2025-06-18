package com.example.recipeapp.FirstScreen.presentation

import com.example.recipeapp.FirstScreen.domain.model.AreaUI

data class StartScreenState(
    val isLoading: Boolean=true,
    val areaList: List<AreaUI> =emptyList()
)
