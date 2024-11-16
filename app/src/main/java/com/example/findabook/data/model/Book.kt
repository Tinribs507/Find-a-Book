package com.example.findabook.data.model

/**
 * Data class representing a Book
 *
 * @property title The title of the book, defaulting to "Unknown Title" if not provided.
 * @property authors The authors of the book, defaulting to an empty list if not provided.
 * @property publisher The publisher of the book, defaulting to "Unknown Publisher" if not provided.
 * @property publishedDate The published date of the book, defaulting to "Unknown Date" if not provided.
 * @property description A brief description of the book, defaulting to "No Description Available" if not provided.
 */
data class Book(
    val title: String? = "Unknown Title",
    val authors: List<String> = emptyList(),
    val publisher: String? = "Unknown Publisher",
    val publishedDate: String? = "Unknown Date",
    val description: String = "No Description Available"
)