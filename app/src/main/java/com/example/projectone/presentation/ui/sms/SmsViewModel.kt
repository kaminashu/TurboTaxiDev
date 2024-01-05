package com.example.projectone.presentation.ui.sms

import androidx.lifecycle.ViewModel
import com.example.projectone.data.imple.RepoImple
import com.example.projectone.domain.entities.CheckResponseSmsModel
import com.example.projectone.domain.entities.ChekRequestSmsModel
import com.example.projectone.domain.usecases.GetSmsUseCase

class SmsViewModel : ViewModel() {
    private val imple = RepoImple()
    private val getSmsUseCase = GetSmsUseCase(imple)
    suspend fun chekSms(requestSmsModel: ChekRequestSmsModel):CheckResponseSmsModel{
        return getSmsUseCase(requestSmsModel)
    }
}