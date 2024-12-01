package com.example.findabook.data.model

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

/**
 * Test class for the Book object.
 * Ensures that all fields of the Book object are correctly initialized and behave as expected.
 */
class BookTest {

    /**
     * Test method to verify the default values of the Books object.
     * Ensures that default values are set correctly when no arguments are provided.
     */
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

    /**
     * Test method to verify custom values of the Books object.
     * Ensures that custom values are set correctly when custom arguments are provided.
     */
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

    /**
     * Test method to verify the equality and hashCode of the Books object.
     *
     * Ensures that two Book objects that have the same values are considered equal
     * and have the same hashCode.
     *
     * Ensures the two Book objects that have different values are not considered equal
     * and don't have the same hashCode.
     */
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