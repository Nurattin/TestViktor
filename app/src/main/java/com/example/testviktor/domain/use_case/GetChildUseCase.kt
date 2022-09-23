package com.example.testviktor.domain.use_case

import com.example.testviktor.domain.repository.GetChildRepository
import javax.inject.Inject

class GetChildUseCase @Inject constructor(private val repo: GetChildRepository) {
    suspend operator fun invoke() = repo.getChild()
}