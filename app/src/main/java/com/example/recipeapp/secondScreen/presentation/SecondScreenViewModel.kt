package com.example.recipeapp.secondScreen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.secondScreen.data.repositoryImpl.RepositoryImpl2
import com.example.recipeapp.secondScreen.domain.repopsitory.Repository2
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SecondScreenViewModel: ViewModel() {

    private val _state= MutableStateFlow(State())
    val state = _state.asStateFlow()

    val repo1: Repository2 = RepositoryImpl2()

    fun getData(region:String,category:String){

        viewModelScope.launch {
            _state.value= state.value.copy(
                foodList = repo1.getData(region,category),
                isLoading = false
            )
        }
    }
}
