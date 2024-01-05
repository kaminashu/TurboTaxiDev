package com.example.projectone.domain.entities

import com.google.gson.annotations.SerializedName

class ChekRequestSmsModel(
    @field:SerializedName("auth_smscheck")
    val authSmscheck: AuthSmscheck
)