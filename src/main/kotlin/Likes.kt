data class Likes(
    var count: Int,
    var userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
) {
}