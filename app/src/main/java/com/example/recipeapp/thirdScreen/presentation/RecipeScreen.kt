package com.example.recipeapp.thirdScreen.presentation

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.recipeapp.thirdScreen.domain.model.RecipeUI
import com.example.recipeapp.R
import androidx.core.net.toUri

@Composable
fun RecipeScreen(modifier: Modifier = Modifier,state3: State3,Food: String )
{
    if(state3.RecipeList.isNotEmpty()) {
        LazyColumn(modifier = modifier) {
            item {
                Text(
                    text = "Recipe of $Food is here",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }
            items(state3.RecipeList) {
                RecipeComponent(recipeUI = it)
            }
        }
    }
    else{
        Column(modifier= Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text="No recipe found from $Food name\n Kindly check spelling or try again later",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center)


        }

    }





}
@Composable
fun RecipeComponent(modifier: Modifier = Modifier,recipeUI: RecipeUI) {

    val scrollState = rememberScrollState()
    Column(modifier=modifier.fillMaxSize()
//        .verticalScroll(scrollState)
    ) {
        AsyncImage(
            model=recipeUI.strMealThumb,
            contentDescription = "Thumbnail",
            modifier=Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )

        Column(modifier= Modifier.fillMaxSize().padding(10.dp)) {
            val ingredientText = recipeUI.ingredient
                .filter { it!!.isNotBlank() }
                .joinToString(", ")

            val annotatedText = buildAnnotatedString {
                append("Ingredients - ")
                addStyle(style = SpanStyle(fontWeight = FontWeight.Bold), start = 0, end = 12)
                append(ingredientText)
            }

            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = annotatedText,
                    fontSize = 15.sp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Text(text = "Instructions",
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp)
            Text(text = recipeUI.strInstructions!!)

            Text(text = "Video ->",
                fontWeight = FontWeight.Bold)
//            if (recipeUI.strYoutube.isNotBlank()) {
            ClickableLink(
                url = recipeUI.strYoutube!!,
                label = "Watch Recipe on YouTube"
            )
//            }
        }
    }

}


@Composable
fun ClickableLink(url: String, label: String = "Watch on YouTube") {
    val context = LocalContext.current

    val annotatedString = buildAnnotatedString {
        pushStringAnnotation(tag = "URL", annotation = url)
        withStyle(
            style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline),
        ) {
            append(label)
        }
        pop()
    }

    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(tag = "URL", start = offset, end = offset)
                .firstOrNull()?.let { annotation ->
                    val intent = Intent(Intent.ACTION_VIEW, annotation.item.toUri())
                    context.startActivity(intent)
                }
        }
    )
}