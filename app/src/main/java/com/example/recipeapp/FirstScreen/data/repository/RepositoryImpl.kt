package com.example.recipeapp.FirstScreen.data.repository

import com.example.recipeapp.FirstScreen.data.Api.ApiClient
import com.example.recipeapp.FirstScreen.domain.Repository.Repository
import com.example.recipeapp.FirstScreen.domain.mapper.toAreaUI
import com.example.recipeapp.FirstScreen.domain.model.AreaUI

class RepositoryImpl: Repository {
    override suspend fun getAreaName(): List<AreaUI> {
        return ApiClient.apiRetrofitClient.getArea().toAreaUI()
    }
}