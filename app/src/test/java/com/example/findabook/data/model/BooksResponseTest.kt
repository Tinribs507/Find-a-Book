package com.example.findabook.data.model

import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class BooksResponseTest {

    private lateinit var volumeInfo: VolumeInfo
    private lateinit var responseItems: ResponseItems
    private lateinit var booksResponse: BooksResponse

    @Before
    fun setUp() {
        // Initialize a VolumeInfo object with sample data
        volumeInfo = VolumeInfo(
            title = "Book 1",
            authors = listOf("Author"),
            publisher = "Publisher",
            publishedDate = "1988",
            description = "Description")

        // Initialize a ResponseItems object with sample data
        responseItems = ResponseItems(
            id = "1",
            volumeInfo = volumeInfo
        )

        // Initialize a BooksResponse object with sample data
        booksResponse = BooksResponse(
            kind = "books#volumes",
            totalItems = 1,
            items = listOf(responseItems)
        )
    }

    @Test
    fun volumeInfo_isInitializedCorrectly() {
        // Test if a BooksResponse is initialized with correct values
        assertEquals("Book 1", volumeInfo.title)
        assertEquals(listOf("Author"), volumeInfo.authors)
        assertEquals("Publisher", volumeInfo.publisher)
        assertEquals("1988", volumeInfo.publishedDate)
        assertEquals("Description", volumeInfo.description)
    }

    @Test
    fun responseItems_isInitializedCorrectly() {
        // Test if a ResponseItems is initialized with correct values
        assertEquals("1", responseItems.id)
        assertEquals(volumeInfo, responseItems.volumeInfo)
    }

    @Test
    fun booksResponse_isInitializedCorrectly() {
        // Test if a BooksResponse is initialized with correct values
        assertEquals("books#volumes", booksResponse.kind)
        assertEquals(1, booksResponse.totalItems)
        assertEquals(listOf(responseItems), booksResponse.items)
    }

    @Test
    fun volumeInfo_equalityAndHashCode() {
        // Test equality and hashCode of VolumeInfo objects
        val volumeInfo2 = VolumeInfo(
            title = "Book 1",
            authors = listOf("Author"),
            publisher = "Publisher",
            publishedDate = "1988",
            description = "Description"
        )
        val volumeInfo3 = VolumeInfo(
            title = "Book 2",
            authors = listOf("Author 2"),
            publisher = "Publisher 2",
            publishedDate = "1989",
            description = "Description")
        assertEquals(volumeInfo, volumeInfo2)
        assertNotEquals(volumeInfo, volumeInfo3)
        assertEquals(volumeInfo.hashCode(), volumeInfo2.hashCode())
        assertNotEquals(volumeInfo.hashCode(), volumeInfo3.hashCode())
    }

    @Test fun responseItems_equalityAndHashCode() {
        // Test equality and hashCode of ResponseItems objects
        val responseItems2 = ResponseItems("1", volumeInfo)
        val responseItems3 = ResponseItems("2", volumeInfo)
        assertEquals(responseItems, responseItems2)
        assertNotEquals(responseItems, responseItems3)
        assertEquals(responseItems.hashCode(), responseItems2.hashCode())
        assertNotEquals(responseItems.hashCode(), responseItems3.hashCode())
    }

    @Test
    fun booksResponse_equalityAndHashCode() {
        // Test equality and hashCode of BooksResponse objects
        val booksResponse2 = BooksResponse(
            kind = "books#volumes",
            totalItems = 1,
            listOf(responseItems)
        )
        val booksResponse3 = BooksResponse(
            kind = "books#volumes",
            totalItems = 3,
            items = listOf(responseItems)
        )
        assertEquals(booksResponse, booksResponse2)
        assertNotEquals(booksResponse, booksResponse3)
        assertEquals(booksResponse.hashCode(), booksResponse2.hashCode())
        assertNotEquals(booksResponse.hashCode(), booksResponse3.hashCode())
    }
}