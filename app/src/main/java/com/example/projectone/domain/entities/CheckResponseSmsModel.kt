package com.example.projectone.domain.entities

import com.google.gson.annotations.SerializedName

data class CheckResponseSmsModel(

	@field:SerializedName("data")
	val data: ChekResponseSmsDataModel,

	@field:SerializedName("res_id")
	val resId: Int,

	@field:SerializedName("mess")
	val mess: String
)