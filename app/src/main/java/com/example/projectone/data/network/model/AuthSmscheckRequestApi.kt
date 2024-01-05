package com.example.projectone.data.network.model

data class AuthSmscheckRequestApi(
	val userIdent: String? = null,
	val smsCode: String? = null,
	val lang: String? = null,
	val isToken: String? = null
)
