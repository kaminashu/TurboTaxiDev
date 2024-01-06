package com.example.projectone.presentation.ui.sms

import androidx.lifecycle.ViewModel
import com.example.projectone.data.imple.RepoImple
import com.example.projectone.domain.entities.AuthSmscheck
import com.example.projectone.domain.entities.CheckResponseSmsModel
import com.example.projectone.domain.entities.ChekRequestSmsModel
import com.example.projectone.domain.usecases.GetSmsUseCase
import kotlinx.coroutines.delay

class SmsViewModel : ViewModel() {
    private val imple = RepoImple()
    private val getSmsUseCase = GetSmsUseCase(imple)
    suspend fun chekSms(token: Int, id: Int, code: String): CheckResponseSmsModel {
        val auth = AuthSmscheck(
            userIdent = id.toString(),
            smsCode = code,
            lang = "uz",
            isToken = token.toString()
        )
        val chekRequestSmsModel = ChekRequestSmsModel(auth)
        return getSmsUseCase(chekRequestSmsModel)
    }
}