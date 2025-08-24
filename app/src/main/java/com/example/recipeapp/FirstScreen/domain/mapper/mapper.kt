package com.example.recipeapp.FirstScreen.domain.mapper

import com.example.recipeapp.FirstScreen.data.DTO.Area.AreaDTO
import com.example.recipeapp.FirstScreen.data.DTO.category.CategoryDTO
import com.example.recipeapp.FirstScreen.domain.model.AreaUI
import com.example.recipeapp.FirstScreen.domain.model.CategoryUI

fun AreaDTO.toAreaUI(): List<AreaUI>{
    return meals.map {area->
        AreaUI(
            strArea = area.strArea
        )

    }
}

fun CategoryDTO.toAreaUIC():List<CategoryUI>{
    return meals.map { area->
        CategoryUI(
            strCategory=area.strCategory
        )
    }
}


