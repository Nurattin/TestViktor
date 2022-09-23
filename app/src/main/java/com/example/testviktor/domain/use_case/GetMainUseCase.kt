package com.example.testviktor.domain.use_case

import com.example.testviktor.domain.repository.GetMainRepository
import javax.inject.Inject

class GetMainUseCase @Inject constructor(private val repo: GetMainRepository) {
    suspend operator fun invoke() = repo.getMain()
}