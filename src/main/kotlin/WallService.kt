object WallService {

    var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

fun update(post: Post) : Boolean{
    /*for ((index, p) in posts.withIndex()){
        if (p.id == post.id){
            posts[index] = post.copy()
        }
        return true
    }
    return false*/
    for (p in posts){
        if (p.id == post.id){
            posts.filter { p.id == post.id }
            posts += post.copy()
            return true
        }
    }
    return false

}



}


