package com.example.testviktor.domain.use_case

import com.example.testviktor.domain.repository.GetBlogRepository
import javax.inject.Inject

class GetBlogUseCase @Inject constructor(private val repo: GetBlogRepository) {
    suspend operator fun invoke() = repo.getBlog()
}