package com.example.recipeapp.secondScreen.presentation.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.recipeapp.R

@Composable
fun RecipeCard(
    RecipeClick: (String) -> Unit,
    title:String,
    imageurl:String) {

    val context=LocalContext.current

    Card(modifier = Modifier
        .padding(40.dp, 10.dp, 10.dp, 10.dp)
        .clickable {
            RecipeClick(title)
            Toast.makeText(context,title, Toast.LENGTH_SHORT).show()

        }, colors = CardDefaults.cardColors(
        containerColor = Color.Transparent
    ), elevation = CardDefaults.cardElevation(
        defaultElevation = 2.dp
    )) {
        Column(
            modifier = Modifier
                .width(200.dp)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally // <-- Center content horizontally
        ) {
            AsyncImage(
                model = imageurl,
                contentDescription = "Photo hai andhe",
                modifier = Modifier
                    .height(350.dp)
                    .width(250.dp)
                    .padding(10.dp),
                contentScale = ContentScale.Crop

            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                textAlign = TextAlign.Center
            )
        }
    }
}

