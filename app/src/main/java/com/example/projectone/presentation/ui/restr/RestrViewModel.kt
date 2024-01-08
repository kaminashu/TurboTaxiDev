package com.example.projectone.presentation.ui.restr

import androidx.lifecycle.ViewModel
import com.example.projectone.data.imple.RepoImple
import com.example.projectone.domain.entities.ReestrRequest
import com.example.projectone.domain.entities.ReestrResponse
import com.example.projectone.domain.usecases.GetReestrUseCase

class RestrViewModel : ViewModel() {
    private val imple = RepoImple()
    private val getReestrUseCase = GetReestrUseCase(imple)
    suspend fun getReestr(reestrRequest: ReestrRequest): ReestrResponse {
        return getReestrUseCase(reestrRequest)
    }
}