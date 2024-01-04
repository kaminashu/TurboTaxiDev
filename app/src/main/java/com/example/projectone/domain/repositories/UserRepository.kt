package com.example.projectone.domain.repositories

import com.example.projectone.domain.entities.RegResponseModel
import com.example.projectone.domain.entities.UserModel

interface UserRepository {
    suspend fun postUser(userModel: UserModel):RegResponseModel
}