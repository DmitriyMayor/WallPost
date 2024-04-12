data class User(
    val id: Int,
    var notes: MutableList<Note>,
    var isMyFriend: Boolean = true,
)