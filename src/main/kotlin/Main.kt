import WallService.add
import WallService.posts
import WallService.update

fun main() {



    val post1 = Post(
        1,
        2,
        3,
        "Hello",
        likes = Likes(0, canLike = true, canPublish = true, userLikes = true),
        views = Views(0),
        postType = "audio"
    )

    val post2 = Post(
        1,
        2,
        3,
        "Hi",
        likes = Likes(0, canLike = true, canPublish = true, userLikes = true),
        views = Views(0),
        postType = "audio"
    )

add(post1)
    println(posts)
    println( update(post2))
    println(posts)



}