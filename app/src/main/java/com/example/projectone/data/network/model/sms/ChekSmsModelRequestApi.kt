package com.example.projectone.data.network.model.sms

import com.google.gson.annotations.SerializedName

data class ChekSmsModelRequestApi(
	@field:SerializedName("auth_smscheck")
	val authSmscheck: AuthSmscheckRequestApi? = null
)
