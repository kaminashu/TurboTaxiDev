package com.example.projectone.domain.entities

import com.google.gson.annotations.SerializedName

data class ChekResponseSmsDataModel(

	@field:SerializedName("user_rolecode")
	val userRolecode: String,

	@field:SerializedName("user_ident")
	val userIdent: String,

	@field:SerializedName("user_county")
	val userCounty: String,

	@field:SerializedName("interfases")
	val interfases: String,

	@field:SerializedName("user_name")
	val userName: String,

	@field:SerializedName("user_region")
	val userRegion: String,

	@field:SerializedName("user_phone_mask")
	val userPhoneMask: String,

	@field:SerializedName("user_rolename")
	val userRolename: String,

	@field:SerializedName("is_token")
	val isToken: String
)