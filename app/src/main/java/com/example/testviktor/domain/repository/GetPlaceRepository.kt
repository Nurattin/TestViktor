package com.example.testviktor.domain.repository

import com.example.testviktor.data.model.Place

interface GetPlaceRepository {
    suspend fun getPlace(): com.example.mappa.data.result.Result<Place>
}