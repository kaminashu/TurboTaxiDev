package com.example.projectone.data.network.model

import com.google.gson.annotations.SerializedName

data class Data(

    @field:SerializedName("user_ident")
    val userIdent: String? = null,

    @field:SerializedName("sms_send")
    val smsSend: Int? = null,

    @field:SerializedName("is_token")
    val isToken: String? = null
)