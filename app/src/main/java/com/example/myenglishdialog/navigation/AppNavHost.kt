package com.example.myenglishdialog.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myenglishdialog.ui.MainScreen
import com.example.myenglishdialog.ui.VideoSelectionScreen
import com.example.myenglishdialog.ui.DialogScreen


@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "main") {
        composable("main") {
            MainScreen(
                onSelectVideoClick = { navController.navigate("videoSelection") },
                onStartDialogClick = { /* TODO */ }
            )
        }
        composable("videoSelection") {
            VideoSelectionScreen(
                onVideoSelected = { selectedVideo ->
                    navController.navigate("dialogScreen/${selectedVideo.id}")
                },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable("dialogScreen/{videoId}") { backStackEntry ->
            val videoId = backStackEntry.arguments?.getString("videoId") ?: return@composable
            DialogScreen(videoId, navController)
        }
    }
}