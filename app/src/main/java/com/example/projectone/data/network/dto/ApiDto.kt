package com.example.projectone.data.network.dto

import com.example.projectone.data.network.model.sms.ChekResponseSms
import com.example.projectone.data.network.model.sms.ChekSmsModelRequestApi
import com.example.projectone.data.network.model.ModelRegResp
import com.example.projectone.data.network.model.UserPost
import com.example.projectone.data.network.model.reestr.ReestrRequestApi
import com.example.projectone.data.network.model.reestr.ReestrResponseApi
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiDto {
    @POST("Panohim/")
    suspend fun getLoginZapros(@Body body: UserPost): ModelRegResp

    @POST("Panohim/")
    suspend fun getSms(@Body body: ChekSmsModelRequestApi): ChekResponseSms

    @POST("Panohim/")
    suspend fun getReestr(@Body body: ReestrRequestApi): ReestrResponseApi

}