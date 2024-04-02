data class Audio (val id: Int,
                  val title: String,
                  val duration: Int,
)

data class AudioAttachment(val audio: Audio): Attachment("audio")