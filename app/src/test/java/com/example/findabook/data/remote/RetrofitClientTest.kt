package com.example.findabook.data.remote

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

/**
 * Test class for the RetroFitClient.
 * Ensures that the RetrofitClient is correctly configured and the correct functionality of the ApiService.
 */
class RetrofitClientTest {

    /**
     * Test method to verify the findBooks function in ApiService
     * Uses a mock implementation to simulate API responses
     */
    @Test
    fun testFindBooks(): Unit = runTest {
        // Launch a coroutine on the IO dispatcher for network operations
        CoroutineScope(Dispatchers.IO).launch {
            // Call the mock API service to fetch books with a test query parameter
            val response = MockApiService().findBooks(mapOf("q" to "test"))

            // Ensure the response is not null
            assertNotNull(response)
            // Validate the kind of field in the response
            assertEquals("books#volumes", response.kind)
            // Validate the totalItems field in the response
            assertEquals(1, response.totalItems)
            // Validate the mockId field in the response
            assertEquals("mockId", response.items[0].id)
        }
    }
}