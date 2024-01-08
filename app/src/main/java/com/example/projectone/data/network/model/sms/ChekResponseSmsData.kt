package com.example.projectone.data.network.model.sms

import com.google.gson.annotations.SerializedName

class ChekResponseSmsData (
        @field:SerializedName("user_rolecode")
        val userRolecode: String? = null,

        @field:SerializedName("user_ident")
        val userIdent: String? = null,

        @field:SerializedName("user_county")
        val userCounty: String? = null,

        @field:SerializedName("interfases")
        val interfases: String? = null,

        @field:SerializedName("user_name")
        val userName: String? = null,

        @field:SerializedName("user_region")
        val userRegion: String? = null,

        @field:SerializedName("user_phone_mask")
        val userPhoneMask: String? = null,

        @field:SerializedName("user_rolename")
        val userRolename: String? = null,

        @field:SerializedName("is_token")
        val isToken: String? = null
)