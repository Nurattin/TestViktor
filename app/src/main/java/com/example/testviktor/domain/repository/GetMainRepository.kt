package com.example.testviktor.domain.repository

import com.example.testviktor.data.model.Main

interface GetMainRepository {
    suspend fun getMain(): com.example.mappa.data.result.Result<Main>
}