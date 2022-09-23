package com.example.testviktor.data.repository

import com.example.mappa.data.result.Result
import com.example.testviktor.data.di.IoDispatcher
import com.example.testviktor.data.model.Foods
import com.example.testviktor.data.remote_datasource.Api
import com.example.testviktor.domain.repository.GetFoodRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetFoodRepositoryImpl @Inject constructor(
    private val api: Api,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : GetFoodRepository {
    override suspend fun getFood(): Result<Foods> = withContext(ioDispatcher) {
        api.getFood()
    }
}