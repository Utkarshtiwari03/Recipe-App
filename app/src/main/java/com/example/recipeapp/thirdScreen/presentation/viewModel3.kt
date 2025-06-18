package com.example.recipeapp.thirdScreen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.thirdScreen.data.RepositoryImpl.RepositoryImpl
import com.example.recipeapp.thirdScreen.domain.Repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class viewModel3: ViewModel() {

    private val _state= MutableStateFlow(State3())
    val state = _state.asStateFlow()

    val repo3: Repository= RepositoryImpl()

    fun getData(Food: String){
        viewModelScope.launch {
            try {
                _state.value=state.value.copy(
                    RecipeList = repo3.getRecipe(Food),
                    isLoading = false
                )
//                log.d("Hello",repo3.getRecipe(Food)[0].idMeal)

            }
            catch(e: Exception){
                _state.value=state.value.copy(
                    isLoading = false
                )
                println("Exception $e")
            }
        }
    }


}