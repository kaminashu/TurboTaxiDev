package com.example.projectone.data.network.model.reestr

import com.google.gson.annotations.SerializedName

class ReestrReqParamsSubModelApi(

    @field:SerializedName("number")
    val number: String? = null,

    @field:SerializedName("date_begin")
    val dateBegin: String? = null,

    @field:SerializedName("region_id")
    val regionId: Int? = null,

    @field:SerializedName("date_end")
    val dateEnd: String? = null,

    @field:SerializedName("user")
    val user: String? = null,

    @field:SerializedName("country_id")
    val countryId: Int? = null,

    @field:SerializedName("status")
    val status: String? = null
)