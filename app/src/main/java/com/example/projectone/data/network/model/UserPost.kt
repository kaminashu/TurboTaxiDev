package com.example.projectone.data.network.model

import com.google.gson.annotations.SerializedName

data class UserPost(

	@field:SerializedName("auth_user")
	val authUser: AuthUser? = null
)


