package com.example.recipeapp.core.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
data object first_Screen

@Serializable
data class second_Screen(val region:String)

@Serializable
data class  thirdScreen(val Food: String)