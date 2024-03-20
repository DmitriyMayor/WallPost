object WallService {

    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (posts[index].id == post.id) {
                posts[index] = post.copy()
            }
            return true
        }
        return false
    }


}