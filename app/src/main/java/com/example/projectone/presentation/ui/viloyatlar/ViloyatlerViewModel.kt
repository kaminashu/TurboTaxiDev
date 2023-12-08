package com.example.projectone.presentation.ui.viloyatlar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViloyatlerViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Viloyatler Fragment"
    }
    val text: LiveData<String> = _text
}