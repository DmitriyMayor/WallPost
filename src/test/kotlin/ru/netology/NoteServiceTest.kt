package ru.netology

import Comment
import Note
import NoteService
import User
import org.junit.Before


import org.junit.Test
import kotlin.test.assertEquals

class NoteServiceTest {

    @Before
    fun clearNotes() {
        NoteService.clearNotes()
    }


    @Test
    fun addNote() {

        val note1 = Note(1, "заголовок", "текст")
        val note2 = Note(2, "заголовок", "текст")

        NoteService.addNote(note1)

        assertEquals(note2, NoteService.addNote(note2))
    }

    @Test
    fun addCommentToNote() {
        val note1 = Note(1, "заголовок", "текст")
        NoteService.addNote(note1)

        val comment = Comment(1, "комментарий")

        assertEquals(comment, NoteService.addCommentToNote(1, comment))

    }

    @Test
    fun deleteNote() {

        val note1 = Note(1, "заголовок", "текст")
        val note2 = Note(2, "заголовок", "текст")

        NoteService.addNote(note1)
        NoteService.addNote(note2)
        NoteService.deleteNote(note2)

        assertEquals(note1, NoteService.getNotes().last())
    }

    @Test
    fun deleteCommentToNote() {

        val note1 = Note(1, "заголовок", "текст")
        NoteService.addNote(note1)

        val comment1 = Comment(1, "комментарий")
        NoteService.addCommentToNote(1, comment1)
        NoteService.deleteCommentToNote(1, comment1)

        assertEquals(true, note1.comments.last().isDeleted)
    }

    @Test
    fun editNote() {

        val note1 = Note(1, "заголовок", "текст")
        val note2 = Note(1, "заголовок2", "текст2")

        NoteService.addNote(note1)
        NoteService.editNote(note2)
        val expected = note2
        val actual = NoteService.getNotes().last()

        assertEquals(expected, actual)

        //NoteService.clearNotes()
    }

    @Test
    fun editCommentToNote() {

        val note1 = Note(1, "заголовок", "текст")
        val comment1 = Comment(1, "коммент")
        val comment2 = Comment(1, "комментар")
        val comment3 = Comment(1, "комментарррр")

        NoteService.addNote(note1)
        NoteService.addCommentToNote(1, comment1)
        NoteService.editCommentToNote(1, comment2)

        val expected = comment2
        val actual = NoteService.editCommentToNote(1, comment2)

        assertEquals(expected, actual, "Ошиблись коммнтарием")

        //NoteService.clearNotes()
    }

    @Test
    fun getNoteById() {

        val note1 = Note(1, "заголовок", "текст")
        val note2 = Note(12, "заголовок2", "текст2")
        val note3 = Note(777, "заголовок3", "текст3")

        NoteService.addNote(note1)
        NoteService.addNote(note2)
        NoteService.addNote(note3)

        val expected = note2
        val actual = NoteService.getNoteById(12)

        assertEquals(expected, actual)
    }

    @Test
    fun getCommentsToNote() {

        val note1 = Note(1, "заголовок", "текст")
        val comment1 = Comment(1, "коммент")
        val comment2 = Comment(2, "комментар", isDeleted = true)
        val comment3 = Comment(3, "комментарррр")

        NoteService.addNote(note1)
        NoteService.addCommentToNote(1, comment1)
        NoteService.addCommentToNote(1, comment2)
        NoteService.addCommentToNote(1, comment3)

        val testComments = mutableListOf<Comment>(comment1, comment3)

        assertEquals(testComments, NoteService.getCommentsToNote(1))

    }

    @Test
    fun getFriendsNotesList() {

        val note1 = Note(1, "заголовок", "текст")
        val note2 = Note(12, "заголовок2", "текст2")
        val note3 = Note(777, "заголовок3", "текст3")

        val friend = User(1, notes = mutableListOf(note1, note2, note3), true)
        val testNotes = mutableListOf(note1, note2, note3)

        assertEquals(testNotes, NoteService.getFriendsNotesList(friend))

    }


    @Test
    fun restoreDeletedComment() {

        val note1 = Note(1, "заголовок", "текст")
        val comment1 = Comment(1, "коммент", true)

        NoteService.addNote(note1)
        NoteService.addCommentToNote(1, comment1)
        NoteService.restoreDeletedComment(note1, commentId = 1)

        assertEquals(false, comment1.isDeleted)

    }

}