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
import org.junit.Before


class WallServiceTest {

    @Before
    fun clearPosts() {
        WallService.clearPosts()
    }

    @Test
    fun testAddPost() {
        val post1 = Post(
            1,
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
            "Hello",
            likes = Likes(0, canLike = true, canPublish = true, userLikes = true),
            views = Views(0),
            postType = "audio",
            original = null
        )

        var service = WallService

        val expected = post2

        service.add(post1)

        assertEquals(expected, service.add(post2))

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
            1,
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
        var service = WallService

        val expected = false
        service.add(post1)

        assertEquals(expected, WallService.update(post2))


    }


    @Test(expected = PostNotFoundException::class)
    fun addCommentException() {
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
        val comment = Comment(1, "тест")

        createComment(4, comment)


    }

    @Test
    fun createComment() {

        val post1 = Post(
            4,
            2,
            3,
            "Hello",
            likes = Likes(0, canLike = true, canPublish = true, userLikes = true),
            views = Views(0),
            postType = "audio",
            original = null

        )
        posts = emptyArray()
        add(post1)
        val comment = Comment(1, "тест")
        assertEquals(comment, createComment(4, comment))


    }
}