package com.example.projectone.presentation.ui.malumotlar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MalumotlarViewModel : ViewModel() {
    private val _fata=MutableLiveData<String>().apply {
    value="Malumotlar fragment"
    }
    val text:LiveData<String> = _fata
}