package com.example.testviktor.domain.repository

import com.example.testviktor.data.model.BlogDetail

interface GetBlogByIdRepository {
    suspend fun getBlogById(blogId: Int): com.example.mappa.data.result.Result<BlogDetail>
}