package com.example.findabook.data.model

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class BookTest {

    @Test
    fun defaultValues_areSetCorrectly() {
        // Create a Book with default values
        val defaultBook = Book()

        // Assert that the default values are set correctly
        assertEquals("Unknown Title", defaultBook.title)
        assertEquals(emptyList<String>(), defaultBook.authors)
        assertEquals("Unknown Publisher", defaultBook.publisher)
        assertEquals("Unknown Date", defaultBook.publishedDate)
        assertEquals("No Description Available", defaultBook.description)
    }

    @Test
    fun customValues_areSetCorrectly() {
        // Create a Book with custom values
        val customBook = Book(
            title = "Custom Title",
            authors = listOf("Author 1", "Author 2"),
            publisher = "Custom Publisher",
            publishedDate = "1988",
            description = "Custom Description"
        )

        // Assert that the custom values are set correctly
        assertEquals("Custom Title", customBook.title)
        assertEquals(listOf("Author 1", "Author 2"), customBook.authors)
        assertEquals("Custom Publisher", customBook.publisher)
        assertEquals("1988", customBook.publishedDate)
        assertEquals("Custom Description", customBook.description)
    }

    @Test
    fun equality_andHashCode_workCorrectly() {
        // Create two Book instances with the same values
        val book1 = Book(title = "The Book")
        val book2 = Book(title = "The Book")
        // Create a third Book instance with different values
        val book3 = Book(title = "Not The Book")

        // Test for equality and hashCode
        assertEquals(book1, book2)
        assertNotEquals(book1, book3)
        assertEquals(book1.hashCode(), book2.hashCode())
        assertNotEquals(book1.hashCode(), book3.hashCode())
    }
}