package com.example.projectone.data.mapper

import com.example.projectone.data.network.model.AuthSmscheckRequestApi
import com.example.projectone.data.network.model.AuthUser
import com.example.projectone.data.network.model.ChekResponseSms
import com.example.projectone.data.network.model.ChekSmsModelRequestApi
import com.example.projectone.data.network.model.ModelRegResp
import com.example.projectone.data.network.model.UserPost
import com.example.projectone.domain.entities.CheckResponseSmsModel
import com.example.projectone.domain.entities.ChekRequestSmsModel
import com.example.projectone.domain.entities.ChekResponseSmsDataModel
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
    fun mapperChekRequestSmsModelToChekRequestApiMopdel(chekRequestSmsModel: ChekRequestSmsModel):ChekSmsModelRequestApi{
        val authSmscheck=AuthSmscheckRequestApi(userIdent = chekRequestSmsModel.authSmscheck.userIdent, smsCode = chekRequestSmsModel.authSmscheck.smsCode,lang=chekRequestSmsModel.authSmscheck.lang, isToken = chekRequestSmsModel.authSmscheck.isToken)
        return ChekSmsModelRequestApi(authSmscheck)
    }
    fun mapperChekResponseSmsApiToChekResponseSmsModel(chekResponseSms: ChekResponseSms): CheckResponseSmsModel {
        val data = ChekResponseSmsDataModel(
            userIdent = chekResponseSms.data?.userIdent ?: "UNKOWN",
            userRolecode = chekResponseSms.data?.userRolecode ?: "UNKOWN",
            userCounty = chekResponseSms.data?.userCounty ?: "UNKOWN",
            isToken = chekResponseSms.data?.isToken ?: "UNKOWN",
            interfases = chekResponseSms.data?.interfases ?: "UNKOWN",
            userName = chekResponseSms.data?.userName ?: "UNKOWN",
            userPhoneMask = chekResponseSms.data?.userPhoneMask ?: "UNKOWN",
            userRegion = chekResponseSms.data?.userRegion ?: "UNKOWN",
            userRolename = chekResponseSms.data?.userRolename ?: "UNKOWN",
        )
        return CheckResponseSmsModel(
            data = data,
            resId = chekResponseSms.resId ?: -1,
            mess = chekResponseSms.mess ?: "UNKOWN"
        )
    }
}