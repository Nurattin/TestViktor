package com.example.testviktor.data.repository

import com.example.mappa.data.result.Result
import com.example.testviktor.data.di.IoDispatcher
import com.example.testviktor.data.model.BlogDetail
import com.example.testviktor.data.remote_datasource.Api
import com.example.testviktor.domain.repository.GetBlogByIdRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetBlogByIdRepositoryImpl @Inject constructor(
    private val api: Api,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
): GetBlogByIdRepository {
    override suspend fun getBlogById(blogId: Int): Result<BlogDetail> = withContext(ioDispatcher){
        api.getBlogById(blogId = blogId)
    }

}