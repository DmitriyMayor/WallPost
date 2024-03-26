object WallService {

    var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

fun update(post: Post) : Boolean{
    for ((index, p) in posts.withIndex()){
        if (p.id == post.id){
            posts[index] = post
        }
        return true
    }
    return false

}


}