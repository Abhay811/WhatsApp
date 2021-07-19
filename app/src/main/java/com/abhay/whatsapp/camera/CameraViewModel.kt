package com.abhay.whatsapp.camera

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CameraViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply{
        value = "You're in Camera Fragment"
    }
    val text: LiveData<String> = _text
}