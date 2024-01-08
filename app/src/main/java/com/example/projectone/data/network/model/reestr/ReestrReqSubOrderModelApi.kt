package com.example.projectone.data.network.model.reestr

import com.google.gson.annotations.SerializedName

class ReestrReqSubOrderModelApi(

    @field:SerializedName("user_ident")
    val userIdent: String? = null,

    @field:SerializedName("action")
    val action: String? = null,

    @field:SerializedName("lang")
    val lang: String? = null,

    @field:SerializedName("params")
    val reqRestrParamsSubModelApi: ReestrReqParamsSubModelApi? = null,

    @field:SerializedName("is_token")
    val isToken: String? = null
)
