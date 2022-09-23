package com.example.testviktor.domain.repository

import com.example.testviktor.data.model.Rooms

interface GetRoomRepository {
    suspend fun getRoom(): com.example.mappa.data.result.Result<Rooms>
}