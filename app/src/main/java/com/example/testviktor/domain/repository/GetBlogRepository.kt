package com.example.testviktor.domain.repository

import com.example.testviktor.data.model.Blog

interface GetBlogRepository {
    suspend fun getBlog(): com.example.mappa.data.result.Result<Blog>
}