package com.example.testviktor.domain.use_case

import com.example.testviktor.domain.repository.GetEntertainmentRepository
import javax.inject.Inject

class GetEntertainmentUseCase @Inject constructor(private val repo: GetEntertainmentRepository) {
    suspend operator fun invoke() = repo.getEntertainment()
}