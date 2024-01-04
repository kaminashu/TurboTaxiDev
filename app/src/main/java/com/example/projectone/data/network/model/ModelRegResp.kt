package com.example.projectone.data.network.model

import com.google.gson.annotations.SerializedName

data class ModelRegResp(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("res_id")
	val resId: Int? = null,

	@field:SerializedName("mess")
	val mess: String? = null
)


