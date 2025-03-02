package com.example.myenglishdialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myenglishdialog.data.repository.DialogueRepository
import com.example.myenglishdialog.ui.screens.DialogueScreen
import com.example.myenglishdialog.ui.screens.MainScreen
import com.example.myenglishdialog.ui.screens.VideoSelectionScreen
import com.example.myenglishdialog.ui.theme.MyEnglishDialogTheme
import com.example.myenglishdialog.ui.viewmodel.DialogueViewModel
import com.example.myenglishdialog.ui.viewmodel.MainViewModel
import com.example.myenglishdialog.ui.viewmodel.VideoSelectionViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = DialogueRepository(this)

        setContent {
            MyEnglishDialogTheme {
                AppNavigation(repository)
            }
        }
    }
}

@Composable
fun AppNavigation(repository: DialogueRepository) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            val viewModel: MainViewModel = viewModel { MainViewModel(repository) }
            MainScreen(
                viewModel = viewModel,
                onSelectVideoClick = { navController.navigate("select_video") },
                onStartDialogueClick = { navController.navigate("dialogue") }
            )
        }

        composable("select_video") {
            val viewModel: VideoSelectionViewModel = viewModel { VideoSelectionViewModel(repository) }
            VideoSelectionScreen(
                viewModel = viewModel,
                onVideoSelected = { navController.popBackStack() }
            )
        }

        composable("dialogue") {
            val viewModel: DialogueViewModel = viewModel { DialogueViewModel(repository) }
            DialogueScreen(
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}



