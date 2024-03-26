data class Post(
    var id: Int,
    var ownerId: Int,
    var fromId: Int,
    var text: String,
    var friendsOnly: Boolean = false,
    var likes: Likes,
    var views: Views,
    var postType: String,
    var markedAsAds: Boolean = false,
    var isFavorite: Boolean = false
)