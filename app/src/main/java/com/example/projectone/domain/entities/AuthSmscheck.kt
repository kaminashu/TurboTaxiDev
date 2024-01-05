package com.example.projectone.domain.entities

import com.google.gson.annotations.SerializedName

 class AuthSmscheck(

	@field:SerializedName("user_ident")
	val userIdent: String,

	@field:SerializedName("sms_code")
	val smsCode: String,

	@field:SerializedName("lang")
	val lang: String,

	@field:SerializedName("is_token")
	val isToken: String
)