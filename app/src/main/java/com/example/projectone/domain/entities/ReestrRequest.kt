package com.example.projectone.domain.entities

import com.google.gson.annotations.SerializedName

data class ReestrRequest(
    @field:SerializedName("order")
    val requestReqSubOrderModel: ReestrReqSubOrderModel? = null
)