package com.example.projectone.presentation.ui.registers

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlin.math.log

class RegistersViewModel : ViewModel() {
    fun isLogin(login:String,parol:String): Boolean {
        Log.d("TAG", "isLogin:$login $parol ")
        return login=="Admin" && parol=="0"
    }
}