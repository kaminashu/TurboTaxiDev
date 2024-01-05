package com.example.projectone.data.network.dto

import com.example.projectone.data.network.model.ChekResponseSms
import com.example.projectone.data.network.model.ChekSmsModelRequestApi
import com.example.projectone.data.network.model.ModelRegResp
import com.example.projectone.data.network.model.UserPost
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiDto {
    @POST("Panohim/")
    suspend fun getLoginZapros(@Body body: UserPost): ModelRegResp
    @POST("Panohim/")
    suspend fun getSms(@Body body: ChekSmsModelRequestApi): ChekResponseSms

}