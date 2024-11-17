package com.example.findabook.data.model

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class BookTest {

    @Test
    fun defaultValues_areSetCorrectly() {
        val defaultBook = Book()

        assertEquals("Unknown Title", defaultBook.title)
        assertEquals(emptyList<String>(), defaultBook.authors)
        assertEquals("Unknown Publisher", defaultBook.publisher)
        assertEquals("Unknown Date", defaultBook.publishedDate)
        assertEquals("No Description Available", defaultBook.description)
    }

    @Test
    fun customValues_areSetCorrectly() {
        val customBook = Book(
            title = "Custom Title",
            authors = listOf("Author 1", "Author 2"),
            publisher = "Custom Publisher",
            publishedDate = "1988",
            description = "Custom Description"
        )

        assertEquals("Custom Title", customBook.title)
        assertEquals(listOf("Author 1", "Author 2"), customBook.authors)
        assertEquals("Custom Publisher", customBook.publisher)
        assertEquals("1988", customBook.publishedDate)
        assertEquals("Custom Description", customBook.description)
    }

    @Test
    fun equality_andHashCode_workCorrectly() {
        val book1 = Book(title = "The Book")
        val book2 = Book(title = "The Book")
        val book3 = Book(title = "Not The Book")

        assertEquals(book1, book2)
        assertNotEquals(book1, book3)
        assertEquals(book1.hashCode(), book2.hashCode())
        assertNotEquals(book1.hashCode(), book3.hashCode())
    }
}