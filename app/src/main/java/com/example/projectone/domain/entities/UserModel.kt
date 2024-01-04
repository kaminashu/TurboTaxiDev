package com.example.projectone.domain.entities

import com.example.projectone.data.network.model.AuthUser
import javax.inject.Inject

class UserModel @Inject constructor(
    val authUser: UserAuthUser? = null
) {
}