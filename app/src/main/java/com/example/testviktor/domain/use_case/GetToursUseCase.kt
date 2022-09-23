package com.example.testviktor.domain.use_case

import com.example.testviktor.domain.repository.GetToursRepository
import javax.inject.Inject

class GetToursUseCase @Inject constructor(private val repo: GetToursRepository) {
    suspend operator fun invoke() = repo.getToursRepository()
}