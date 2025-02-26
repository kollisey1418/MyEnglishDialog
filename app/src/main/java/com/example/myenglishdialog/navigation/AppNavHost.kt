package com.example.myenglishdialog.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myenglishdialog.ui.MainScreen
import com.example.myenglishdialog.ui.VideoSelectionScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "main") {
        composable("main") {
            MainScreen(
                onSelectVideoClick = { navController.navigate("video") },
                onStartDialogClick = { /* TODO */ }
            )
        }
        composable("video") {
            VideoSelectionScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
