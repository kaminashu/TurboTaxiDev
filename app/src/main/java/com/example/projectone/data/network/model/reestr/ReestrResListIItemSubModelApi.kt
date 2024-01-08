package com.example.projectone.data.network.model.reestr

import com.google.gson.annotations.SerializedName

data class ReestrResListIItemSubModelApi(

	@field:SerializedName("number")
	val number: String? = null,

	@field:SerializedName("date_in")
	val dateIn: String? = null,

	@field:SerializedName("add_data")
	val addData: List<ReestrResViloyatSubModelApi>? = null,

	@field:SerializedName("user")
	val user: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)
