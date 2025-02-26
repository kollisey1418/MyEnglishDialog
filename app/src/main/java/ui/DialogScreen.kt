package com.example.myenglishdialog.ui

import com.example.myenglishdialog.utils.extractYouTubeId
import android.annotation.SuppressLint
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.myenglishdialog.data.Dialog
import com.example.myenglishdialog.data.Video
import com.example.myenglishdialog.data.VideoRepository
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding

@Composable
fun DialogScreen(videoId: String, navController: NavController) {
    val video = VideoRepository.getVideoById(videoId.toInt())
    val dialogLines: List<Dialog> = remember { video?.dialogs ?: emptyList() }
    var currentLineIndex by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Воспроизведение YouTube видео
        YouTubePlayer(video?.url ?: "")

        Spacer(modifier = Modifier.height(16.dp))

        // Отображение диалогов
        if (dialogLines.isNotEmpty()) {
            Text(text = dialogLines[currentLineIndex].text)

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (currentLineIndex < dialogLines.size - 1) {
                        currentLineIndex++
                    } else {
                        navController.popBackStack()
                    }
                }
            ) {
                Text(if (currentLineIndex < dialogLines.size - 1) "Далее" else "Завершить")
            }
        }
    }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun YouTubePlayer(videoUrl: String) {
    val context = LocalContext.current

    AndroidView(
        factory = { ctx ->
            val youTubePlayerView = YouTubePlayerView(ctx).apply {
                layoutParams = FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }

            (ctx as ComponentActivity).lifecycle.addObserver(youTubePlayerView)

            youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    val videoId = extractYouTubeId(videoUrl)
                    videoId?.let { youTubePlayer.loadVideo(it, 0f) }
                }
            })

            youTubePlayerView
        }
    )
}


