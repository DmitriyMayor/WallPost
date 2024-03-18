data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val text: String,
    val friendsOnly: Boolean = false,
    val likes: Likes,
    val views: Views,
    val postType: String,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false
) {
}