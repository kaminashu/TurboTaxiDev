package com.example.projectone.data.imple

import com.example.projectone.data.mapper.Mapper
import com.example.projectone.data.network.api.ApiCilent
import com.example.projectone.data.network.dto.ApiDto
import com.example.projectone.domain.entities.CheckResponseSmsModel
import com.example.projectone.domain.entities.ChekRequestSmsModel
import com.example.projectone.domain.entities.ReestrRequest
import com.example.projectone.domain.entities.ReestrResponse
import com.example.projectone.domain.entities.RegResponseModel
import com.example.projectone.domain.entities.UserModel
import com.example.projectone.domain.repositories.UserRepository

class RepoImple : UserRepository {
    val mapper = Mapper()
    val network = ApiCilent.getRetrofit().create(ApiDto::class.java)
    override suspend fun postUser(userModel: UserModel): RegResponseModel {
        val post = mapper.mapperUserModelToUserPost(userModel)
        val loginZapros = network.getLoginZapros(post)
        return mapper.mapperModelRegRespToUserRegResponseModel(loginZapros)
    }

    override suspend fun chekSms(chekRequestSmsModel: ChekRequestSmsModel): CheckResponseSmsModel {
        val sms = network.getSms(
            mapper.mapperChekRequestSmsModelToChekRequestApiMopdel(chekRequestSmsModel)
        )
        return mapper.mapperChekResponseSmsApiToChekResponseSmsModel(sms)
    }
    override suspend fun getReestr(reestrRequest: ReestrRequest): ReestrResponse {
        val reestr = network.getReestr(mapper.mapperRestrRequestToReestrRequestAPi(reestrRequest))
        return mapper.mapperReestResponseApiToReestrResponse(reestr)
    }

}