package com.example.projectone.domain.entities

import com.google.gson.annotations.SerializedName

data class ReestrResponse(

	@field:SerializedName("res_id")
	val resId: Int? = null,

	@field:SerializedName("mess")
	val mess: String? = null,

	@field:SerializedName("list")
	val list: List<ReestrResListIItemSubModel?>? = null
)
