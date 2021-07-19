package com.abhay.whatsapp.model

data class ChatList (
    val userID: String,
    private val userName: String,
    private val description: String,
    val date: String,
    val urlProfile: String

)