package com.example.recipeapp.core.data.Api

import com.example.recipeapp.core.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val retrofitinit by lazy {
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

