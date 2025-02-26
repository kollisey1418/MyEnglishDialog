package com.example.myenglishdialog.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VideoSelectionScreen(onBackClick: () -> Unit) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Экран выбора видео")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onBackClick) {
            Text("Назад")
        }
    }
}
