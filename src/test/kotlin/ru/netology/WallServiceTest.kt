package ru.netology

import Comment
import Likes
import Post
import PostNotFoundException
import Views
import WallService
import WallService.add
import WallService.createComment
import WallService.posts
import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun testAddPost() {
        val post1 = Post(
            2,
            2,
            3,
            "Hello",
            likes = Likes(0, canLike = true, canPublish = true, userLikes = true),
            views = Views(0),
            postType = "audio",
            original = null

        )

        val post2 = Post(
            1,
            2,
            3,
            "Hello",
            likes = Likes(0, canLike = true, canPublish = true, userLikes = true),
            views = Views(0),
            postType = "audio",
            original = null
        )
        val expected = post2

        WallService.add(post1)
        WallService.add(post2)
        assertEquals(expected, posts.last())
    }

    @Test
    fun updatePositive() {
        val post1 = Post(
            2,
            2,
            3,
            "Hello",
            likes = Likes(0, canLike = true, canPublish = true, userLikes = true),
            views = Views(0),
            postType = "audio",
            original = null
        )

        val post2 = Post(
            2,
            2,
            3,
            "Hi",
            likes = Likes(0, canLike = true, canPublish = true, userLikes = true),
            views = Views(0),
            postType = "audio",
            original = null
        )
        val expected = true
        WallService.add(post1)

        assertEquals(expected, WallService.update(post2))

    }

    @Test
    fun updateNegative() {
        val post1 = Post(
            2,
            2,
            3,
            "Hello",
            likes = Likes(0, canLike = true, canPublish = true, userLikes = true),
            views = Views(0),
            postType = "audio",
            original = null
        )

        val post2 = Post(
            3,
            2,
            3,
            "Hi",
            likes = Likes(0, canLike = true, canPublish = true, userLikes = true),
            views = Views(0),
            postType = "audio",
            original = null
        )
        val expected = false
        WallService.add(post1)

        assertEquals(expected, WallService.update(post2))

    }

    @Test
    fun addComment(){
        val post1 = Post(
            2,
            2,
            3,
            "Hello",
            likes = Likes(0, canLike = true, canPublish = true, userLikes = true),
            views = Views(0),
            postType = "audio",
            original = null
        )
        WallService.add(post1)
        val comment = Comment("комментарий")
        val expected = Comment("комментарий")
        val actual = createComment(2, comment)

        assertEquals(expected, actual)


    }

    @Test(expected = PostNotFoundException::class)
    fun addCommentException(){
        val post1 = Post(
            3,
            2,
            3,
            "Hello",
            likes = Likes(0, canLike = true, canPublish = true, userLikes = true),
            views = Views(0),
            postType = "audio",
            original = null
        )
        add(post1)
        val comment = Comment("комментарий")

        createComment(4, comment)



    }
}