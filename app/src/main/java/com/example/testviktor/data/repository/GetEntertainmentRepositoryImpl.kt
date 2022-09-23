package com.example.testviktor.data.repository

import com.example.mappa.data.result.Result
import com.example.testviktor.data.di.IoDispatcher
import com.example.testviktor.data.model.Entertainment
import com.example.testviktor.data.remote_datasource.Api
import com.example.testviktor.domain.repository.GetEntertainmentRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetEntertainmentRepositoryImpl @Inject constructor(
    private val api: Api,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : GetEntertainmentRepository {
    override suspend fun getEntertainment(): Result<Entertainment> = withContext(ioDispatcher) {
        api.getEntertainment()
    }
}