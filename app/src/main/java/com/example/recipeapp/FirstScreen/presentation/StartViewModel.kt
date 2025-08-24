package com.example.recipeapp.FirstScreen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.FirstScreen.data.repository.RepositoryImpl
import com.example.recipeapp.FirstScreen.domain.Repository.Repository
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
                getArea("Cuisine")
            }

            is StartScreenEvents.getCategory ->{
                getArea(events.Category)
//                if(events.Category=="Categories"){
//
//                }
//                else{
//                    getArea()
//                }
            }
        }
    }

   fun getArea(category: String) {
       viewModelScope.launch {
           try {

               _state.value = state.value.copy(
                   isLoading = false,
                   areaList = if(category=="Cuisine") repo.getAreaName() else emptyList(),
                   categoryList = if(category=="Categories") repo.getCategoryName() else emptyList()
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
        getArea("Cuisine")
    }
}