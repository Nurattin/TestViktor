package com.example.testviktor.data.repository

import com.example.mappa.data.result.Result
import com.example.testviktor.data.di.IoDispatcher
import com.example.testviktor.data.model.Place
import com.example.testviktor.data.remote_datasource.Api
import com.example.testviktor.domain.repository.GetPlaceRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPlaceRepositoryImpl @Inject constructor(
    private val api: Api,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : GetPlaceRepository {
    override suspend fun getPlace(): Result<Place> = withContext(ioDispatcher) {
        api.getPlace()
    }
}