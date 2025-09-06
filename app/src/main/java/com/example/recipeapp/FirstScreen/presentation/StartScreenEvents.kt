package com.example.recipeapp.FirstScreen.presentation

sealed class StartScreenEvents {

//    object getArea: StartScreenEvents()
    data class getCategory(val Category: String): StartScreenEvents()
}