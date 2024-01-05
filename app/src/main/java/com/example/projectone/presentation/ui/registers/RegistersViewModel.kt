package com.example.projectone.presentation.ui.registers

import androidx.lifecycle.ViewModel
import com.example.projectone.data.imple.RepoImple
import com.example.projectone.domain.entities.RegResponseModel
import com.example.projectone.domain.entities.UserAuthUser
import com.example.projectone.domain.entities.UserModel
import com.example.projectone.domain.usecases.GetUserUseCases

class RegistersViewModel : ViewModel() {
    private val imple = RepoImple()
    private val getUserUseCases = GetUserUseCases(imple)
    suspend fun isLogin(login: String, parol: String): RegResponseModel {
        val userModel = UserModel(UserAuthUser(password = parol, login = login, lang = "uz"))
        return getUserUseCases(userModel)
    }



}