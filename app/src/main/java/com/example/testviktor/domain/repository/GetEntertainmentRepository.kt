package com.example.testviktor.domain.repository

import com.example.testviktor.data.model.Entertainment

interface GetEntertainmentRepository {
    suspend fun getEntertainment(): com.example.mappa.data.result.Result<Entertainment>
}