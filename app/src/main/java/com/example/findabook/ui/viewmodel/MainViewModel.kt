package com.example.findabook.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.findabook.data.model.Book
import com.example.findabook.data.model.BooksResponse
import com.example.findabook.data.repository.BooksRepository

class MainViewModel : ViewModel() {

    // Repository instance to handle data operations
    private val repository = BooksRepository()

    // LiveData to hold the list of books retrieved from the repository
    private val _books = MutableLiveData<List<Book>>()

    // Public LiveData to expose the list of books to the UI
    val books: LiveData<List<Book>> get() = _books

    private val _selectedOption = MutableLiveData("With all words")
    private val selectedOption: LiveData<String> get() = _selectedOption

    private val _keyWordsQuery = MutableLiveData<String>()
    val keyWordsQuery: LiveData<String> get() = _keyWordsQuery

    private val _titleQuery = MutableLiveData<String>()
    val titleQuery: LiveData<String> get() = _titleQuery

    private val _authorQuery = MutableLiveData<String>()
    val authorQuery: LiveData<String> get() = _authorQuery

    private val _publisherQuery = MutableLiveData<String>()
    val publisherQuery: LiveData<String> get() = _publisherQuery

    private val _subjectQuery = MutableLiveData<String>()
    val subjectQuery: LiveData<String> get() = _subjectQuery

    fun updateSelectedOption(option: String) {
        _selectedOption.value = option
    }

    // Updates the key words query
    fun updateKeyWordsQuery(query: String) {
        _keyWordsQuery.value = query
    }

    // Updates the title query
    fun updateTitleQuery(query: String) {
        _titleQuery.value = query
    }

    // Updates the author query
    fun updateAuthorQuery(query: String) {
        _authorQuery.value = query
    }

    // Updates the publisher query
    fun updatePublisherQuery(query: String) {
        _publisherQuery.value = query
    }

    // Updates the subject query
    fun updateSubjectQuery(query: String) {
        _subjectQuery.value = query
    }

    /**
     * Fetches books based on the current search parameters.
     * It builds the query parameters from the current LiveData values, calls the repository to fetch books
     * and updates the _books LiveData with the results
     */
    fun fetchBooks() {
        repository.searchBooks(
            selectedOption = selectedOption.value ?: "",
            keyWords = keyWordsQuery.value ?: "",
            inTitle = titleQuery.value ?: "",
            inAuthor = authorQuery.value ?: "",
            inPublisher = publisherQuery.value ?: "",
            subject = subjectQuery.value ?: ""
        ) { booksResponse ->
            booksResponse?.let {
                val bookList = mapToBookList(booksResponse)
                _books.postValue(bookList)
            }
        }
    }

    /**
     * Maps the BooksResponse from the API to a list of Book objects.
     *
     * @param booksResponse The response from the Google Books API.
     * @return A list of Book objects.
     */
    private fun mapToBookList(booksResponse: BooksResponse): List<Book> {
        return booksResponse.items.map { item ->
            val volumeInfo = item.volumeInfo
            val imageLinks = volumeInfo.imageLinks
            Book(
                title = volumeInfo.title ?: "Unknown Title",
                authors = volumeInfo.authors ?: emptyList(),
                publisher = volumeInfo.publisher ?: "Unknown Publisher",
                publishedDate = volumeInfo.publishedDate ?: "Unknown Date",
                description = volumeInfo.description ?: "No Description",
                imageLinks = imageLinks
            )
        }
    }
}