package com.example.projectone.domain.entities

import com.google.gson.annotations.SerializedName

class ReestrReqSubOrderModel(

    @field:SerializedName("user_ident")
    val userIdent: String? = null,

    @field:SerializedName("action")
    val action: String? = null,

    @field:SerializedName("lang")
    val lang: String? = null,

    @field:SerializedName("params")
    val reqRestrParamsSubModel: ReestrReqParamsSubModel? = null,

    @field:SerializedName("is_token")
    val isToken: String? = null
)
