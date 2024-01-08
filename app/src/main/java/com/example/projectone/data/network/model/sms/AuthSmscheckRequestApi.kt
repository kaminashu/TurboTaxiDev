package com.example.projectone.data.network.model.sms

import com.google.gson.annotations.SerializedName

data class AuthSmscheckRequestApi(
	@field:SerializedName("user_ident")
	val userIdent: String? = null,

	@field:SerializedName("sms_code")
	val smsCode: String? = null,

	@field:SerializedName("lang")
	val lang: String? = null,

	@field:SerializedName("is_token")
	val isToken: String? = null
)
