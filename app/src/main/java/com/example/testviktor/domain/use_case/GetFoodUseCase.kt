package com.example.testviktor.domain.use_case

import com.example.testviktor.domain.repository.GetFoodRepository
import javax.inject.Inject

class GetFoodUseCase @Inject constructor(private val repo: GetFoodRepository) {
    suspend operator fun invoke() = repo.getFood()
}