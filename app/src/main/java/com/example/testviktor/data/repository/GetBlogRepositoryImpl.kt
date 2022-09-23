package com.example.testviktor.data.repository

import com.example.mappa.data.result.Result
import com.example.testviktor.data.di.IoDispatcher
import com.example.testviktor.data.model.Blog
import com.example.testviktor.data.remote_datasource.Api
import com.example.testviktor.domain.repository.GetBlogRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetBlogRepositoryImpl @Inject constructor(
    private val api: Api,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : GetBlogRepository {
    override suspend fun getBlog(): Result<Blog> = withContext(ioDispatcher) {
        api.getBlog()
    }

}