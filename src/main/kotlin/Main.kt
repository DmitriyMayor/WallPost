import WallService.posts


fun main() {

    val service = WallService


    var post1 = Post(
        3,
        2,
        3,
        "Hello",
        likes = Likes(0, canLike = true, canPublish = true, userLikes = true),
        views = Views(0),
        postType = "audio",
        original = null
    )

    var post2 = Post(
        3,
        2,
        3,
        "Hi",
        likes = Likes(0, canLike = true, canPublish = true, userLikes = true),
        views = Views(0),
        postType = "audio",
        original = null
    )

    service.add(post1)
    println(service.posts)
    service.update(post2)
    //service.createComment(3, comment = Comment("комментарий"))
    println(service.posts)



    //var noteService = NoteService
    //var note = Note(1,"первая", "заметка")
    //noteService.addNote(note)
    //println(noteService.notes)




}