package com.example.recipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.recipeapp.core.presentation.ui.theme.RecipeAppTheme
import com.example.recipeapp.FirstScreen.presentation.StartScreen
import com.example.recipeapp.FirstScreen.presentation.StartViewModel
import androidx.compose.runtime.getValue
import com.example.recipeapp.core.presentation.navigation.SetUpNav
import com.example.recipeapp.secondScreen.presentation.SecondScreen
import com.example.recipeapp.secondScreen.presentation.SecondScreenViewModel
import com.example.recipeapp.thirdScreen.presentation.RecipeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    SetUpNav(modifier = Modifier.fillMaxSize().padding(innerPadding))
//
//                    val viewModel: SecondScreenViewModel= viewModel()
//
//                    val state by viewModel.state.collectAsStateWithLifecycle()

//                    SecondScreen(modifier = Modifier.fillMaxSize().padding(innerPadding),
//                        state,
//                        onEvent  = {
//                            viewModel.onEvent(it)
//                        },
//                    )

//                    StartScreen(
//                        modifier = Modifier.fillMaxSize().padding(innerPadding),
//                        state,
////                        onEvent  = {
////                            viewmodel.onEvent(it)
////                        },
//                    )
                }
            }
        }
    }
}
