package com.example.recipeapp.FirstScreen.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
fun SearchBar(modifier: Modifier = Modifier,
              clicked:()-> Unit,
              filterClicked:(String)-> Unit
) {

    var query by remember { mutableStateOf("") }
    var expanded by remember {mutableStateOf(false)}

    Row(modifier = Modifier.fillMaxWidth().padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
        Card(
            modifier = Modifier.weight(1f).padding(12.dp).clickable {},
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(10.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .clickable {
                    clicked()
                    },
                verticalAlignment = Alignment.CenterVertically// Row click to make sure TextField area is clickable
            ) {
                Icon(Icons.Default.Search, contentDescription = "Search")
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = if (query.isEmpty()) "Search..." else query,
                    color = if (query.isEmpty()) Color.Gray else Color.Black
                )
            }
        }
        Spacer(Modifier.width(8.dp))

        Box {
            IconButton(onClick = {
                expanded = true
            }) {
                Icon(
                    imageVector = Icons.Default.Menu, // example: filter button
                    contentDescription = "Filter"
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Categories") },
                    onClick = {
                        expanded = false
                        filterClicked("Categories")
                    }
                )
                DropdownMenuItem(
                    text = { Text("Cuisine") },
                    onClick = {
                        expanded = false
                        filterClicked("Cuisine")
                    }
                )
            }
        }
    }
}