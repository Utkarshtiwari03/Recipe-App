package com.example.recipeapp.secondScreen.presentation

sealed class Events {
    data class getData(val region: String):Events()
}