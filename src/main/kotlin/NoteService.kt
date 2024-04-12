object NoteService {

    private var notes = mutableListOf<Note>()


    fun addNote(note: Note): Note {
        notes.add(note)
        return notes.last()
    }

    fun addCommentToNote(noteId: Int, comment: Comment): Comment {
        for (note in notes) {
            if (note.id == noteId) {
                note.comments += comment
                return note.comments.last()

            }
        }
        throw NoteNotFoundException()

    }

    fun deleteNote(note: Note) {
        for (n in notes) {
            if (n == note) {
                notes.remove(n)
                break
            }
        }


    }

    fun deleteCommentToNote(noteId: Int, comment: Comment) {
        for (note in notes) {
            if (note.id == noteId) {
                for (c in note.comments) {
                    if (c == comment) {
                        note.comments.remove(c)
                        break
                    }
                }
            }
        }

    }

    fun editNote(note: Note) {
        for (n in notes) {
            if (n.id == note.id) {
                val index = notes.indexOf(n)
                notes[index] = note

            }
        }

    }

    fun editCommentToNote(noteId: Int, comment: Comment): Comment {
        for (note in notes) {
            if (note.id == noteId) {
                for (c in note.comments) {
                    if (c.id == comment.id) {
                        c.text = comment.text
                        return c
                    } //else note.comments.plus(comment)
                }
            }
        }
        throw CommentNotFoundException()
    }

    fun getNotes(): List<Note>{
        return notes
    }


    fun getNoteById(noteId: Int): Note {
        for (note in notes) {
            if (note.id == noteId)
                return note
        }
        throw NoteNotFoundException()
    }

    fun getCommentsToNote(noteId: Int): MutableList<Comment> {
        for (note in notes) {
            if (note.id == noteId)
                return note.comments
        }
        throw NoteNotFoundException()
    }

    fun getFriendsNotesList(user: User): List<Note> {
        if (user.isMyFriend){
            return user.notes
        }
        throw UserNotMyFriendException()
    }

    fun restoreDeletedComment(note: Note, commentId: Int) {
        for (comment in note.comments) {
            if (comment.id == commentId && comment.isDeleted)
                comment.isDeleted = false
        }



    }

    fun clearNotes(){
        notes.clear()


    }
}