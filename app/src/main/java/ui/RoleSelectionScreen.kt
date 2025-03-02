package com.example.myenglishdialog.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.MaterialTheme


@Composable
fun RoleSelectionScreen(videoId: String, navController: NavController) {
    var selectedRole by remember { mutableStateOf("Дин") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Выберите персонажа", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        // Пока доступен только Дин
        Button(
            onClick = {
                navController.navigate("dialogScreen/$videoId/$selectedRole")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Играть за Дина")
        }
    }
}
