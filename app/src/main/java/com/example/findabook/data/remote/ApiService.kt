package com.example.findabook.data.remote

import com.example.findabook.data.model.BooksResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Interface defining an API endpoint for interacting with the Google Books API.
 */
interface ApiService {
    /**
     * Search for books using a map of query options.
     *
     * @param options A map of query parameters to search for books.
     * @return A Call object for the request that returns a BooksResponse.
     */
    @GET("volumes")
    fun findBooks(@QueryMap options: Map<String, String>): Call<BooksResponse>
}