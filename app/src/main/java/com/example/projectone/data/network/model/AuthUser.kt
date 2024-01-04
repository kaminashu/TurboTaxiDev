package com.example.projectone.data.network.model

import com.google.gson.annotations.SerializedName

data class AuthUser(

    @field:SerializedName("password")
    val password: String? = null,

    @field:SerializedName("lang")
    val lang: String? = null,

    @field:SerializedName("login")
    val login: String? = null
)