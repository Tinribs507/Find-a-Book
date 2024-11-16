package com.example.findabook.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Object representing a Retrofit client for making API requests.
 */

object RetrofitClient {
    // Base URL for the Google Books API
    private const val BASE_URL = "https://www.googleapis.com/books/v1/"

    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }
}