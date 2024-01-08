package com.example.projectone.presentation.ui.sms

import androidx.lifecycle.ViewModel
import com.example.projectone.data.imple.RepoImple
import com.example.projectone.domain.entities.AuthSmscheck
import com.example.projectone.domain.entities.CheckResponseSmsModel
import com.example.projectone.domain.entities.ChekRequestSmsModel
import com.example.projectone.domain.entities.ReestrRequest
import com.example.projectone.domain.entities.ReestrResponse
import com.example.projectone.domain.usecases.GetReestrUseCase
import com.example.projectone.domain.usecases.GetSmsUseCase
import kotlinx.coroutines.delay

class SmsViewModel : ViewModel() {
    private val imple = RepoImple()
    private val getSmsUseCase = GetSmsUseCase(imple)
    private val getReestrUseCase = GetReestrUseCase(imple)
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

    suspend fun getReestr(reestrRequest: ReestrRequest): ReestrResponse {
        return getReestrUseCase(reestrRequest)
    }
}