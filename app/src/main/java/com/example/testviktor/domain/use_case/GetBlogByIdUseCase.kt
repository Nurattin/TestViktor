package com.example.testviktor.domain.use_case

import com.example.testviktor.domain.repository.GetBlogByIdRepository
import javax.inject.Inject

class GetBlogByIdUseCase @Inject constructor(
    private val repo: GetBlogByIdRepository,
) {
    suspend operator fun invoke(blogId: Int) = repo.getBlogById(blogId = blogId)
}