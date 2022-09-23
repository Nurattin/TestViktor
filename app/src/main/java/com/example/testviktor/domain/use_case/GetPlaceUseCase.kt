package com.example.testviktor.domain.use_case

import com.example.testviktor.domain.repository.GetPlaceRepository
import javax.inject.Inject

class GetPlaceUseCase @Inject constructor(private val repo: GetPlaceRepository) {
    suspend operator fun invoke() = repo.getPlace()
}