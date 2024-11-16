package com.example.findabook.data.repository

import android.util.Log
import com.example.findabook.data.model.BooksResponse
import com.example.findabook.data.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Repository class for interacting with the Google Books API.
 */
class BooksRepository {
    private val apiService = RetrofitClient.instance

    /**
     * A function to search for books for searching the Google Books API.
     *
     * @param selectedOption The selected search option.
     * @param keyWords The keywords to search for.
     * @param inTitle The title to search for.
     * @param inAuthor The author to search for.
     * @param inPublisher The publisher to search for.
     * @param subject The subject to search for.
     * @param callback A callback function to handle the API response.
     */
    fun searchBooks(
        selectedOption: String,
        keyWords: String,
        inTitle: String,
        inAuthor: String,
        inPublisher: String,
        subject: String,
        callback: (BooksResponse?) -> Unit
    ) {
        // The query parameters for the API request
        val queryMap = buildQueryMap(
            selectedOption, keyWords, inTitle, inAuthor, inPublisher, subject
        )

        val call = keyWords.let { apiService.findBooks(queryMap) }
        call.enqueue(object : Callback<BooksResponse> {
            override fun onResponse(call: Call<BooksResponse>, response: Response<BooksResponse>) {
                if (response.isSuccessful) {
                    callback(response.body())
                    Log.d("RESPONSE", "Successful")
                }
            }

            override fun onFailure(call: Call<BooksResponse>, t: Throwable) {
                Log.e("API Error", t.message ?: "Unknown error")
                callback(null)
            }
        })
    }

    /** Builds a query map for searching books using various parameters.
     *
     * @param selectedOption The option chosen for keyword search.
     * @param keyWords The keywords for the search query.
     * @param inTitle Search parameter for book titles.
     * @param inAuthor Search parameter for book authors.
     * @param inPublisher Search parameter for book publishers.
     * @param subject Search parameter for book subjects.
     * @return A map containing the constructed search query.
     */
    private fun buildQueryMap(
        selectedOption: String,
        keyWords: String,
        inTitle: String,
        inAuthor: String,
        inPublisher: String,
        subject: String
    ): Map<String, String> {
        val queryBuilder = StringBuilder()

        // Append formatted keywords based on the selected option
        if (selectedOption.isNotEmpty()) {
            val formattedKeywords = when (selectedOption) {
                "With all words" -> keyWords.replace(" ", "+")
                "Exact phrase" -> "\"$keyWords\""
                "With at least one" -> keyWords.replace(" ", "+OR+")
                else -> "-" + keyWords.replace(" ", "+-")
            }
            queryBuilder.append(formattedKeywords)
        }

        // Append additional search parameters if they are not blank
        if (inTitle.isNotBlank())
            queryBuilder.append("+intitle:$inTitle")

        if (inAuthor.isNotBlank())
            queryBuilder.append("+inauthor:$inAuthor")

        if (inPublisher.isNotBlank())
            queryBuilder.append("+inpublisher:$inPublisher")

        if (subject.isNotBlank())
            queryBuilder.append("+subject:$subject")

        // Return the constructed query map
        return mapOf("q" to queryBuilder.toString())
    }
}
