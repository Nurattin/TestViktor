package com.example.testviktor.domain.repository

import com.example.testviktor.data.model.Child

interface GetChildRepository {
    suspend fun getChild(): com.example.mappa.data.result.Result<Child>
}