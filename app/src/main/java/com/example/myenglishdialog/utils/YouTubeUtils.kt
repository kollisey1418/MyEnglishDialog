package com.example.myenglishdialog.utils

fun extractYouTubeId(url: String): String? {
    return url.substringAfter("v=", "").takeIf { it.isNotEmpty() }
}
