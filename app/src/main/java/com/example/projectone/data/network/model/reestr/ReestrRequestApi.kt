package com.example.projectone.data.network.model.reestr

import com.google.gson.annotations.SerializedName

data class ReestrRequestApi(
    @field:SerializedName("order")
    val reestrResponseSubOrderModel: ReestrReqSubOrderModelApi? = null
)