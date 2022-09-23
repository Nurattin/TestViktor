package com.example.testviktor.domain.repository

import com.example.testviktor.data.model.Tours

interface GetToursRepository {
    suspend fun getToursRepository(): com.example.mappa.data.result.Result<Tours>
}