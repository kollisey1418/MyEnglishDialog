package com.example.myenglishdialog.data

data class Dialog(
    val id: Int,
    val role: String,
    val text: String,
    val timestamp: Int,
    val options: List<String> = emptyList(), // Варианты ответов
    val correctOptionIndex: Int? = null     // Индекс правильного ответа
)
