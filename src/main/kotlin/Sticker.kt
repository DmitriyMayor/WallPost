data class Sticker (val id: Int,
                    val picture: String,
)

data class StickerAttachment(val sticker: Sticker): Attachment("sticker")