package com.example.testviktor.data.repository

import com.example.testviktor.data.di.IoDispatcher
import com.example.testviktor.data.model.Main
import com.example.testviktor.data.remote_datasource.Api
import com.example.testviktor.domain.repository.GetMainRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMainRepositoryImpl @Inject constructor(
    private val api: Api,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : GetMainRepository {
    override suspend fun getMain(): com.example.mappa.data.result.Result<Main> =
        withContext(ioDispatcher) {
            api.getMain()
        }
}