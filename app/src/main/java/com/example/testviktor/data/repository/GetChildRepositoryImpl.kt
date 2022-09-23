package com.example.testviktor.data.repository

import com.example.mappa.data.result.Result
import com.example.testviktor.data.di.IoDispatcher
import com.example.testviktor.data.model.Child
import com.example.testviktor.data.remote_datasource.Api
import com.example.testviktor.domain.repository.GetChildRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetChildRepositoryImpl @Inject constructor(
    private val api: Api,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : GetChildRepository {
    override suspend fun getChild(): Result<Child> = withContext(ioDispatcher) {
        api.getChild()
    }
}