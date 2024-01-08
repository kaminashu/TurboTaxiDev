package com.example.projectone.domain.entities

import com.google.gson.annotations.SerializedName

data class ReestrResViloyatSubModel(

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("value")
	val value: String? = null
)
