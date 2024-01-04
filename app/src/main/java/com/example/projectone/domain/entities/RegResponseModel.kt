package com.example.projectone.domain.entities

import com.example.projectone.data.network.model.Data
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

class RegResponseModel @Inject constructor(
    val data: ResDataMoel? = null,
    val resId: Int? = null,
    val mess: String? = null
) {
}