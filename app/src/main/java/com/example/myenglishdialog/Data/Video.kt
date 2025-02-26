package com.example.myenglishdialog.data

data class Video(
    val id: Int,
    val title: String,
    val url: String,
    val dialogs: List<Dialog>
)
