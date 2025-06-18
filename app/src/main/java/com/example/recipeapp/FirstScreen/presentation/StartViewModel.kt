package com.example.recipeapp.FirstScreen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.FirstScreen.data.repository.RepositoryImpl
import com.example.recipeapp.FirstScreen.domain.Repository.Repository
import com.example.recipeapp.secondScreen.presentation.Events
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StartViewModel : ViewModel() {

    private val _state= MutableStateFlow(StartScreenState())
    val state=_state.asStateFlow()

    val repo: Repository= RepositoryImpl()

    fun onEvent(events: StartScreenEvents){
        when(events){
            StartScreenEvents.getArea -> {
                getArea()
            }
        }
    }

   fun getArea(){
       viewModelScope.launch {
           try {
               val area = repo.getAreaName()
               _state.value = state.value.copy(
                   isLoading = false,
                   areaList = area
               )
           }
           catch (e: Exception){
               _state.value = state.value.copy(
                   isLoading = false
               )
               println("Exception error $e")
           }
       }
    }

    init {
        getArea()
    }
}