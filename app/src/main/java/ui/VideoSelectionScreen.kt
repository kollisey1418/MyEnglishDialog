package com.example.myenglishdialog.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.myenglishdialog.data.Video
import com.example.myenglishdialog.data.VideoRepository
import coil.compose.AsyncImage
import com.example.myenglishdialog.utils.extractYouTubeId


@Composable
fun VideoSelectionScreen(
    onVideoSelected: (Video) -> Unit,
    onBackClick: () -> Unit
) {
    val videos = VideoRepository.getAllVideos()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Выбор видео",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        LazyColumn {
            items(videos) { video ->
                VideoItem(video = video, onClick = { onVideoSelected(video) })
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun VideoItem(video: Video, onClick: (Video) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable { onClick(video) }
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter("https://img.youtube.com/vi/${extractYouTubeId(video.url)}/0.jpg"),
                contentDescription = "Thumbnail",
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(video.title)
        }
    }
}


