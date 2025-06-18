package com.example.recipeapp.FirstScreen.domain.mapper

import com.example.recipeapp.FirstScreen.data.DTO.AreaDTO
import com.example.recipeapp.FirstScreen.domain.model.AreaUI

fun AreaDTO.toAreaUI(): List<AreaUI>{
    return meals.map {area->
        AreaUI(
            strArea = area.strArea
        )

    }
}
