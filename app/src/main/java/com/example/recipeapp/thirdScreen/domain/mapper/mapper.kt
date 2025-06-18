package com.example.recipeapp.thirdScreen.domain.mapper

import com.example.recipeapp.thirdScreen.data.DTO.RecipeDTO
import com.example.recipeapp.thirdScreen.domain.model.RecipeUI


fun RecipeDTO.toRecipeUI(): List<RecipeUI>{
    return meals.map {it->
        RecipeUI(
            idMeal = it.idMeal,
            strMeal = it.strMeal,
            strCategory = it.strCategory,
            strArea = it.strArea,
            strInstructions = it.strInstructions,
            strMealThumb = it.strMealThumb,
            strTags = it.strTags,
            strYoutube = it.strYoutube,
            ingredient = listOf(
                it.strIngredient1, it.strIngredient2, it.strIngredient3, it.strIngredient4, it.strIngredient5,
                it.strIngredient6, it.strIngredient7, it.strIngredient8, it.strIngredient9, it.strIngredient10,
                it.strIngredient11, it.strIngredient12, it.strIngredient13, it.strIngredient14, it.strIngredient15,
                it.strIngredient16, it.strIngredient17, it.strIngredient18, it.strIngredient19, it.strIngredient20
        ),
            strMeasure1 = it.strMeasure1,
            strMeasure2 = it.strMeasure2,
            strMeasure3 = it.strMeasure3,
            strMeasure4 = it.strMeasure4,
            strMeasure5 = it.strMeasure5,
            strMeasure6 = it.strMeasure6,
            strMeasure7 = it.strMeasure7,
            strMeasure8 = it.strMeasure8,
            strMeasure9 = it.strMeasure9,
            strMeasure10 = it.strMeasure10,
            strMeasure11 = it.strMeasure11,
            strMeasure12 = it.strMeasure12,
            strMeasure13 = it.strMeasure13,
            strMeasure14 = it.strMeasure14,
            strMeasure15 = it.strMeasure15,
            strMeasure16 = it.strMeasure16,
            strMeasure17 = it.strMeasure17,
            strMeasure18 = it.strMeasure18,
            strMeasure19 = it.strMeasure19,
            strMeasure20 = it.strMeasure20,

        )
    }
}