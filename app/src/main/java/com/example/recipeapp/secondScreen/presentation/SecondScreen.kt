package com.example.recipeapp.secondScreen.presentation

import android.graphics.Region
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipeapp.secondScreen.presentation.components.RecipeCard

@Composable
fun SecondScreen(modifier: Modifier = Modifier,state: State,region: String?,onClick:(String)-> Unit) {

    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),

            ) {
            Text(
                text = if(region==null) "hello" else region,
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }


        LazyRow(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(state.foodList) {
                RecipeCard(
                    title = it.strMeal, imageurl = it.strMealThumb, RecipeClick = onClick,
                )

            }

        }
    }
}