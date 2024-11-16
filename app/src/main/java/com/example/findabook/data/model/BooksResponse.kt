package com.example.findabook.data.model

/**
 * Data class representing the response from the Google Books API.
 *
 * @property kind The kind of response.
 * @property totalItems The total number of items found.
 * @property items The list of ResponseItems containing book details.
 */
data class BooksResponse(
    val kind: String,
    val totalItems: Int,
    val items: List<ResponseItems>
)

/**
 * Data class representing an item from Google Books API.
 *
 * @property id The unique identifier for the book.
 * @property volumeInfo The detailed information about the book.
 */
data class ResponseItems(
    val id: String,
    val volumeInfo: VolumeInfo
)

/**
 * Data class representing the detailed information about the book
 *
 * @property title The title of the book.
 * @property authors A list of authors of the book.
 * @property publisher The publisher of the book.
 * @property publishedDate The publication date of the book.
 * @property description A brief description of the book.
 */
data class VolumeInfo(
    val title: String,
    val authors: List<String>,
    val publisher: String,
    val publishedDate: String,
    val description: String
)