package com.example.projectone.domain.entities

import com.google.gson.annotations.SerializedName
import javax.inject.Inject

class ResDataMoel @Inject constructor(
    val userIdent: String? = null,
    val smsSend: Int? = null,
    val isToken: String? = null
)