package com.example.testviktor.data.repository

import com.example.mappa.data.result.Result
import com.example.testviktor.data.di.IoDispatcher
import com.example.testviktor.data.model.Rooms
import com.example.testviktor.data.remote_datasource.Api
import com.example.testviktor.domain.repository.GetRoomRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetRoomRepositoryImpl @Inject constructor(
    private val api: Api,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : GetRoomRepository {
    override suspend fun getRoom(): Result<Rooms> = withContext(ioDispatcher) {
        api.getRooms()
    }
}