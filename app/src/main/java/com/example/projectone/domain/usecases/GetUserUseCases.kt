package com.example.projectone.domain.usecases

import com.example.projectone.domain.entities.UserModel
import com.example.projectone.domain.repositories.UserRepository

class GetUserUseCases(private val repository: UserRepository) {
    suspend operator fun invoke(userModel: UserModel) = repository.postUser(userModel)
}