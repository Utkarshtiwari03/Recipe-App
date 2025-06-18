package com.example.recipeapp.FirstScreen.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.recipeapp.FirstScreen.presentation.components.categoryCard


@Composable
fun StartScreen(modifier: Modifier = Modifier,
                state: StartScreenState,
                onEvent:(StartScreenEvents)->Unit,
                onClick:(String)-> Unit) {
    Column(modifier= modifier) {

        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (state.isLoading) {
                CircularProgressIndicator()
            }
            else if (state.areaList.isNotEmpty()) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    textAlign = TextAlign.Center,
                    text = "What would you like\n to cook today?",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,

                    )
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(128.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalArrangement = Arrangement.Center,
                    contentPadding = PaddingValues(10.dp)
                ) {
                    items(state.areaList) {
                        categoryCard(
                            stringResourceId = it.strArea,
                        ) {
                            onClick(it)
                        }
                    }
                }
            }
            else{
                Text(text = "Oops!! NO Internet Connection")
                Button(onClick = {
                    onEvent(StartScreenEvents.getArea)
                }) { Text("Retry")}
            }
        }
    }
}