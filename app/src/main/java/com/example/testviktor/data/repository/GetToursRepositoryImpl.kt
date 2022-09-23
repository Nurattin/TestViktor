package com.example.testviktor.data.repository

import com.example.mappa.data.result.Result
import com.example.testviktor.data.di.IoDispatcher
import com.example.testviktor.data.model.Tours
import com.example.testviktor.data.remote_datasource.Api
import com.example.testviktor.domain.repository.GetToursRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetToursRepositoryImpl @Inject constructor(
    private val api: Api,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : GetToursRepository {
    override suspend fun getToursRepository(): Result<Tours> = withContext(ioDispatcher) {
        api.getTours()
    }
}