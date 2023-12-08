package com.example.projectone.presentation.ui.hisobot

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HisobotViewModel : ViewModel() {
   private val _text=MutableLiveData<String>().apply {
        value="Hisobot framgent"
    }
    val text:LiveData<String> = _text
}