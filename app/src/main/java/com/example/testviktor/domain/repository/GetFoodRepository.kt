package com.example.testviktor.domain.repository

import com.example.testviktor.data.model.Foods

interface GetFoodRepository {
    suspend fun getFood(): com.example.mappa.data.result.Result<Foods>
}