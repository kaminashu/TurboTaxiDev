package com.example.projectone.domain.usecases

import com.example.projectone.domain.entities.ReestrRequest
import com.example.projectone.domain.repositories.UserRepository

class GetReestrUseCase(val repository: UserRepository) {
    suspend operator fun invoke(reestrRequest: ReestrRequest) = repository.getReestr(reestrRequest)
}