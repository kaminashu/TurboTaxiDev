package com.example.projectone.domain.usecases

import com.example.projectone.domain.entities.CheckResponseSmsModel
import com.example.projectone.domain.entities.ChekRequestSmsModel
import com.example.projectone.domain.repositories.UserRepository

class GetSmsUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(chekRequestSmsModel: ChekRequestSmsModel)=repository.chekSms(chekRequestSmsModel)
}