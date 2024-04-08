object WallService {

    var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

    fun update(post: Post): Boolean {

        for (p in posts) {
            if (p.id == post.id) {
                posts.filter { p.id == post.id }
                posts += post.copy()
                return true
            }
        }
        return false

    }

    fun createComment(postId: Int, comment: Comment): Comment {
        for (post in posts) {
            if (post.id == postId) {
                post.comments += comment
            } else throw PostNotFoundException()

        }

        return comment
    }

}


