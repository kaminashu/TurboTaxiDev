package com.example.projectone.domain.entities

import javax.inject.Inject

class UserAuthUser @Inject constructor(
    var login:String,
    var password:String,
    var lang:String="uz"
) {
}