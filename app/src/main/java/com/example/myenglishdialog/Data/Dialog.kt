package com.example.myenglishdialog.data

data class Dialog(
    val id: Int,
    val role: String,
    val text: String,
    val timestamp: Int? = null // Время в секундах (необязательно)
)
