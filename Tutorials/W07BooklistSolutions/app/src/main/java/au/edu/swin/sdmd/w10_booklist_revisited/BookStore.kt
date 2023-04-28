package au.edu.swin.sdmd.w10_booklist_revisited

object BookStore {

    val books = listOf(
        Book("Mobilities", 4.0F, "2581744"),
        Book("Pascal", 1.0F, "9999512"),
        Book("The Hitchhiker's Guide to the Galaxy", 5.0F, "8594912"),
        Book("Concepts of modern art", 2.0F,"316050")
    )

    val count = books.size

    val booksShort = books.subList(0,(books.size/2).toInt())
    val countShort = booksShort.size
}
