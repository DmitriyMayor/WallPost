data class Video(val id: Int,
                 val title: String,
                 val duration: Int,
    )

data class VideoAttachment(val video: Video): Attachment("video")