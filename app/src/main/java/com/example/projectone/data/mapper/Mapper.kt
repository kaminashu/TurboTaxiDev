package com.example.projectone.data.mapper

import com.example.projectone.data.network.model.sms.AuthSmscheckRequestApi
import com.example.projectone.data.network.model.AuthUser
import com.example.projectone.data.network.model.sms.ChekResponseSms
import com.example.projectone.data.network.model.sms.ChekSmsModelRequestApi
import com.example.projectone.data.network.model.ModelRegResp
import com.example.projectone.data.network.model.UserPost
import com.example.projectone.data.network.model.reestr.ReestrReqParamsSubModelApi
import com.example.projectone.data.network.model.reestr.ReestrReqSubOrderModelApi
import com.example.projectone.data.network.model.reestr.ReestrRequestApi
import com.example.projectone.data.network.model.reestr.ReestrResListIItemSubModelApi
import com.example.projectone.data.network.model.reestr.ReestrResViloyatSubModelApi
import com.example.projectone.data.network.model.reestr.ReestrResponseApi
import com.example.projectone.domain.entities.CheckResponseSmsModel
import com.example.projectone.domain.entities.ChekRequestSmsModel
import com.example.projectone.domain.entities.ChekResponseSmsDataModel
import com.example.projectone.domain.entities.ReestrRequest
import com.example.projectone.domain.entities.ReestrResListIItemSubModel
import com.example.projectone.domain.entities.ReestrResViloyatSubModel
import com.example.projectone.domain.entities.ReestrResponse
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

    fun mapperChekRequestSmsModelToChekRequestApiMopdel(chekRequestSmsModel: ChekRequestSmsModel): ChekSmsModelRequestApi {
        val authSmscheck = AuthSmscheckRequestApi(
            userIdent = chekRequestSmsModel.authSmscheck.userIdent,
            smsCode = chekRequestSmsModel.authSmscheck.smsCode,
            lang = chekRequestSmsModel.authSmscheck.lang,
            isToken = chekRequestSmsModel.authSmscheck.isToken
        )
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
            userRolename = chekResponseSms.data?.userRolename ?: "UNKOWN"
        )
        return CheckResponseSmsModel(
            data = data,
            resId = chekResponseSms.resId ?: -1,
            mess = chekResponseSms.mess ?: "UNKOWN"
        )
    }

    fun mapperRestrRequestToReestrRequestAPi(restrRequest: ReestrRequest): ReestrRequestApi {
        val reesreReqParamsSubModelApi = ReestrReqParamsSubModelApi(
            number = restrRequest.requestReqSubOrderModel?.reqRestrParamsSubModel?.number,
            dateBegin = restrRequest.requestReqSubOrderModel?.reqRestrParamsSubModel?.dateBegin,
            regionId = restrRequest.requestReqSubOrderModel?.reqRestrParamsSubModel?.regionId,
            dateEnd = restrRequest.requestReqSubOrderModel?.reqRestrParamsSubModel?.dateEnd,
            user = restrRequest.requestReqSubOrderModel?.reqRestrParamsSubModel?.user,
            countryId = restrRequest.requestReqSubOrderModel?.reqRestrParamsSubModel?.countryId,
            status = restrRequest.requestReqSubOrderModel?.reqRestrParamsSubModel?.status
        )
        return ReestrRequestApi(
            ReestrReqSubOrderModelApi(
                userIdent = restrRequest.requestReqSubOrderModel?.userIdent,
                action = restrRequest.requestReqSubOrderModel?.action,
                lang = restrRequest.requestReqSubOrderModel?.lang,
                reqRestrParamsSubModelApi = reesreReqParamsSubModelApi,
                isToken = restrRequest.requestReqSubOrderModel?.isToken
            )
        )
    }

    fun mapperReestResponseApiToReestrResponse(reestrResponseApi: ReestrResponseApi?): ReestrResponse {
        return ReestrResponse(
            resId = reestrResponseApi?.resId,
            mess = reestrResponseApi?.mess,
            list = mapListresstrApiToListResstr(reestrResponseApi?.list)
        )
    }

    private fun replaseListItem(reestrResListIItemSubModelApi: ReestrResListIItemSubModelApi?): ReestrResListIItemSubModel {
        return ReestrResListIItemSubModel(
            number = reestrResListIItemSubModelApi?.number,
            dateIn = reestrResListIItemSubModelApi?.dateIn,
            addData = mapListReestrAddDataApiToReestrListAddData(reestrResListIItemSubModelApi?.addData),
            user = reestrResListIItemSubModelApi?.user,
            status = reestrResListIItemSubModelApi?.status
        )
    }

    private fun replaseViloyatApiToViloyatModel(reestrResViloyatSubModelApi: ReestrResViloyatSubModelApi?): ReestrResViloyatSubModel {
        return ReestrResViloyatSubModel(
            title = reestrResViloyatSubModelApi?.title, value = reestrResViloyatSubModelApi?.value
        )
    }

    fun mapListresstrApiToListResstr(list: List<ReestrResListIItemSubModelApi?>?) =
        list?.map { replaseListItem(it) }

    fun mapListReestrAddDataApiToReestrListAddData(list: List<ReestrResViloyatSubModelApi?>?) =
        list?.map { replaseViloyatApiToViloyatModel(it) }
}