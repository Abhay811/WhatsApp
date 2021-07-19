package com.abhay.whatsapp.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingsViewModel: ViewModel() {
    private val _text = MutableLiveData<String>().apply{
        value = "You're in Settings Fragment"
    }
    val text: LiveData<String> = _text
}