package com.example.testviktor.domain.use_case

import com.example.testviktor.domain.repository.GetRoomRepository
import javax.inject.Inject

class GetRoomUseCase @Inject constructor(private val repo: GetRoomRepository) {
    suspend operator fun invoke() = repo.getRoom()
}