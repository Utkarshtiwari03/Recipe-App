package com.example.recipeapp.searchScreen.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SearchScreen(modifier: Modifier = Modifier,
                 onSearchClick:(String)-> Unit
) {
    var query by remember { mutableStateOf("") }

    Card(modifier = modifier.fillMaxWidth().padding(12.dp),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(10.dp),
//        onClick = {
//            clicked(query)
//        }
    ){
        Row(modifier= Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(24.dp)).background(Color.White)
            ){
            BasicTextField(
                value = query,
                onValueChange = {
                    query=it
                },
                singleLine = true,
                modifier = Modifier.weight(1f).padding(horizontal = 16.dp,vertical=12.dp),
                decorationBox = {innerTextField ->
                    if(query.isEmpty()){
                        Text("Search...",color=Color.Gray)
                    }
                    innerTextField()
                }
            )
            Box(
                modifier= Modifier.fillMaxHeight().width(56.dp)
                    .background(Color(0xFF535262),
                        shape = RoundedCornerShape(topEnd=24.dp, bottomEnd = 24.dp))
                    .clickable{
                        onSearchClick(query)
                    },
                contentAlignment= Alignment.Center
            ){
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint=Color.White
                )
            }
        }
//        OutlinedTextField(
//            modifier=Modifier.fillMaxWidth(),
//            value = query,
//            onValueChange = {
//                query = it
//            },
//            placeholder = { Text("Search...") },
//            leadingIcon = {Icon(Icons.Default.Search, contentDescription = "Search")},
//            singleLine = true,
//            trailingIcon = {
//                IconButton(onClick = {},
//                modifier= Modifier.height(40.dp).background(Color(0xFF535262)
//                    ).size(36.dp))
//                {
//                Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFFFFFFFF))
//            }
//            }
//        )
    }
}