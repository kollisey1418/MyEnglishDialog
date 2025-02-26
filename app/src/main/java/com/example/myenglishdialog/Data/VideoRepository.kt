package com.example.myenglishdialog.data

object VideoRepository {

    private val sampleDialogs1 = listOf(
        Dialog(id = 1, role = "Дин", text = "Привет, Сэм", timestamp = 10),
        Dialog(id = 2, role = "Сэм", text = "Привет, Дин. Как дела?", timestamp = 14),
        Dialog(id = 3, role = "Дин", text = "Все отлично! Готов к охоте?", timestamp = 20)
    )

    private val sampleDialogs2 = listOf(
        Dialog(id = 1, role = "Доктор", text = "Как вы себя чувствуете?", timestamp = 5),
        Dialog(id = 2, role = "Пациент", text = "Намного лучше, спасибо.", timestamp = 9),
        Dialog(id = 3, role = "Доктор", text = "Отлично! Давайте проверим анализы.", timestamp = 15)
    )

    private val videos = listOf(
        Video(
            id = 1,
            title = "Сцена из Сверхъестественного",
            url = "https://www.youtube.com/watch?v=WHiSrEbgOEA",
            dialogs = sampleDialogs1
        ),
        Video(
            id = 2,
            title = "Диалог у врача",
            url = "https://www.youtube.com/watch?v=UF46wCIink0&t=36s",
            dialogs = sampleDialogs2
        )
    )

    fun getAllVideos(): List<Video> = videos

    fun getVideoById(id: Int): Video? = videos.find { it.id == id }

    fun getDialogsForVideo(videoId: Int): List<Dialog> =
        videos.find { it.id == videoId }?.dialogs ?: emptyList()
}
