package com.example.projectone.presentation.ui.foydalanuvchilar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FoydalanuvchilarViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Foydalanuvchilar Fragment"
    }
    val text: LiveData<String> = _text
}