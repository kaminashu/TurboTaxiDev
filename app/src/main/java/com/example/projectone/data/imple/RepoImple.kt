package com.example.projectone.data.imple

import com.example.projectone.data.mapper.Mapper
import com.example.projectone.data.network.api.ApiCilent
import com.example.projectone.data.network.dto.ApiDto
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

}