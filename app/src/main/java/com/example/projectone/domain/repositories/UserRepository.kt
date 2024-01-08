package com.example.projectone.domain.repositories

import com.example.projectone.domain.entities.CheckResponseSmsModel
import com.example.projectone.domain.entities.ChekRequestSmsModel
import com.example.projectone.domain.entities.ChekResponseSmsDataModel
import com.example.projectone.domain.entities.ReestrRequest
import com.example.projectone.domain.entities.ReestrResponse
import com.example.projectone.domain.entities.RegResponseModel
import com.example.projectone.domain.entities.UserModel

interface UserRepository {
    suspend fun postUser(userModel: UserModel): RegResponseModel
    suspend fun chekSms(chekRequestSmsModel: ChekRequestSmsModel): CheckResponseSmsModel
    suspend fun getReestr(reestrRequest: ReestrRequest): ReestrResponse
}