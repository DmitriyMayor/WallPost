data class Geo (val id: Int,
                val description: String,
)

data class GeoAttachment(val geo: Geo) : Attachment("geo")