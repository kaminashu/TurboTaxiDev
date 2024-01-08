package com.example.projectone.data.network.model.reestr

import com.google.gson.annotations.SerializedName

data class ReestrResponseApi(

	@field:SerializedName("res_id")
	val resId: Int? = null,

	@field:SerializedName("mess")
	val mess: String? = null,

	@field:SerializedName("list")
	val list: List<ReestrResListIItemSubModelApi?>? = null
)
