package com.example.projectone.data.network.dto

import com.example.projectone.data.network.model.ModelRegResp
import com.example.projectone.data.network.model.UserPost
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiDto {
    @POST("Panohim/")
    suspend fun getLoginZapros(@Body body: UserPost): ModelRegResp

}