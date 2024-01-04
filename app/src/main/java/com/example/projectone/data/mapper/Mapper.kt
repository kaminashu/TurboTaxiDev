package com.example.projectone.data.mapper

import com.example.projectone.data.network.model.AuthUser
import com.example.projectone.data.network.model.ModelRegResp
import com.example.projectone.data.network.model.UserPost
import com.example.projectone.domain.entities.RegResponseModel
import com.example.projectone.domain.entities.ResDataMoel
import com.example.projectone.domain.entities.UserModel

class Mapper {
    fun mapperUserModelToUserPost(userModel: UserModel): UserPost {
        val authUser = AuthUser(
            password = userModel.authUser?.password,
            lang = "uz",
            login = userModel.authUser?.login
        )
        return UserPost(authUser)
    }
    fun mapperModelRegRespToUserRegResponseModel(modelRegResp: ModelRegResp): RegResponseModel {
        val data = ResDataMoel(
            userIdent = modelRegResp.data?.userIdent,
            smsSend = modelRegResp.data?.smsSend,
            isToken = modelRegResp.data?.isToken
        )
        return RegResponseModel(data = data, resId = modelRegResp.resId, mess = modelRegResp.mess)
    }
}