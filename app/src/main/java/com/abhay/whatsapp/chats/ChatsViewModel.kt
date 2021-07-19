package com.abhay.whatsapp.chats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ChatsViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply{
        value = "You're in Chats Fragment"
    }
    val text: LiveData<String> = _text
}