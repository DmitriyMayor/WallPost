data class File (val id: Int,
                 val title: String,

)

data class FileAttachment(val file: File): Attachment("file")