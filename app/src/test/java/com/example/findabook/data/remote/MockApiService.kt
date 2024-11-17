package com.example.findabook.data.remote

import com.example.findabook.data.model.BooksResponse
import com.example.findabook.data.model.ResponseItems
import com.example.findabook.data.model.VolumeInfo

/**
 * Mock implementation of the ApiService interface for testing purposes.
 * This class provides a predefined response for the findBooks function.
 */
class MockApiService : ApiService {

    /**
     * Simulates fetching books from the API with provided query options.
     *
     * @param options A map of query parameters for the API request.
     * @return A mock BooksResponse with predefined book details
     */
    override suspend fun findBooks(options: Map<String, String>): BooksResponse {
        // Create a mock VolumeInfo object with predefined values
        val volumeInfo = VolumeInfo(
            title = "Mock Title",
            authors = listOf("Mock Author"),
            publisher = "Mock Publisher",
            publishedDate = "Mock Date",
            description = "Mock Description"
        )

        // Create a mock ResponseItems object containing the mock VolumeInfo
        val responseItems = ResponseItems(
            id = "mockId",
            volumeInfo = volumeInfo
        )

        // Return a BooksResponse object containing the mock ResponseItems
        return BooksResponse("books#volumes", 1, listOf(responseItems))
    }
}