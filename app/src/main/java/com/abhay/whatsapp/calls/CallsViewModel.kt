package com.abhay.whatsapp.calls

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CallsViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply{
        value = "You're in Calls Fragment"
    }
    val text: LiveData<String> = _text
}