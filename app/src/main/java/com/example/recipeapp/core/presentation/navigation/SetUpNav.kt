package com.example.recipeapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.recipeapp.FirstScreen.presentation.StartScreen
import com.example.recipeapp.FirstScreen.presentation.StartViewModel
import com.example.recipeapp.secondScreen.presentation.SecondScreenViewModel
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.recipeapp.secondScreen.presentation.SecondScreen
import com.example.recipeapp.thirdScreen.presentation.RecipeScreen
import com.example.recipeapp.thirdScreen.presentation.viewModel3

@Composable
fun SetUpNav(modifier: Modifier = Modifier) {

    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = first_Screen){

        composable<first_Screen> {
            val viewModel: StartViewModel = viewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()
            StartScreen(modifier = modifier, state = state, onEvent = {
                viewModel.onEvent(it)
            },onClick={
                navController.navigate(second_Screen(region = it))
            })
        }


        composable<second_Screen> {

            val args=it.toRoute<second_Screen>()
            val viewmodel2: SecondScreenViewModel = viewModel()
            LaunchedEffect(Unit) {
                viewmodel2.getData(args.region)
            }
            val state2 by viewmodel2.state.collectAsStateWithLifecycle()
            SecondScreen(modifier = modifier,state = state2, region = args.region, onClick = {
                navController.navigate(thirdScreen(it))
            })
        }

        composable<thirdScreen> {
            val viewModel3:viewModel3=viewModel()
            val args=it.toRoute<thirdScreen>()

            val state3 by viewModel3.state.collectAsStateWithLifecycle()

            LaunchedEffect(Unit) {
                viewModel3.getData(args.Food)
            }
            RecipeScreen(modifier = modifier,state3=state3,Food=args.Food)

        }
    }
}