package com.example.projectone.domain.entities

import com.google.gson.annotations.SerializedName

data class ReestrResListIItemSubModel(

	@field:SerializedName("number")
	val number: String? = null,

	@field:SerializedName("date_in")
	val dateIn: String? = null,

	@field:SerializedName("add_data")
	val addData: List<ReestrResViloyatSubModel>? = null,

	@field:SerializedName("user")
	val user: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)
