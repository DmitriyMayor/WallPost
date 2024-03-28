package ru.netology

import Likes
import Post
import Views
import WallService
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
            postType = "audio"
        )

        val post2 = Post(
            1,
            2,
            3,
            "Hello",
            likes = Likes(0, canLike = true, canPublish = true, userLikes = true),
            views = Views(0),
            postType = "audio"
        )
        val expected = post2

        WallService.add(post1)
        WallService.add(post2)
        assertEquals(expected, WallService.posts.last())
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
            postType = "audio"
        )

        val post2 = Post(
            2,
            2,
            3,
            "Hi",
            likes = Likes(0, canLike = true, canPublish = true, userLikes = true),
            views = Views(0),
            postType = "audio"
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
            postType = "audio"
        )

        val post2 = Post(
            3,
            2,
            3,
            "Hi",
            likes = Likes(0, canLike = true, canPublish = true, userLikes = true),
            views = Views(0),
            postType = "audio"
        )
        val expected = false
        WallService.add(post1)

        assertEquals(expected, WallService.update(post2))

    }
}