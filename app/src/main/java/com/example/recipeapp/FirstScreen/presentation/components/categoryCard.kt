package com.example.recipeapp.FirstScreen.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipeapp.R

@Composable
fun categoryCard(stringResourceId: String,
//                 imageResourceId:Int=R.drawable.brakfast,
                 categoryClick: (String) -> Unit){

    val category_name=stringResourceId
    Card(
        modifier= Modifier.height(170.dp).width(170.dp).clickable{
            categoryClick(category_name)
        }.padding(15.dp,15.dp,15.dp,5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(Color.Black)) {
        Box(modifier = Modifier.fillMaxSize()){
//            Image(painter = painterResource(imageResourceId), contentDescription = "Image of resource")

            Box(modifier = Modifier.padding(8.dp).fillMaxSize().align(Alignment.BottomCenter),
            ) {
                Text(
                    text = "$category_name",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}