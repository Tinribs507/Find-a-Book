# Find a Book (FAB) App

This is a simple Android application that utilizes Google Books API to allow users to search for books by keywords, titles, authors, subjects, and publishers.
After the user enters the search criteria they are navigated to a results pages that displays a relevant list of books.

## Features

* Keyword Search: Search for books using various keywords.
* Advances Search Options: Filter results by book titles, authors, publishers and subjects.
* Results Display: View a list of books that match the search criteria on a dedicated results page.
* Detailed Book Information: Access detailed information about each book.

## Technologies Used

* Kotlin: For developing the Android application.
* Jetpack Compose: For builing the UI in a declarative manner.
* Retrofit: For making API calls to the Google Books API.
* Moshi: For JSON parsing.
* ViewModel & LiveData: For managing UI-related data and lifecycle-conscious data updates.
* Unit Testing & Mockito: For ensuring code correctness and reliability through tests using Junit

## Future Enhancements:

* Extended Information: Implement a click feature on the books card, that takes users to a display with more info about the book.
* Pagination: Implement pagination to load more results as the user scrolls.
* Favorites: Allow users to save their favourite books.
* Offline Support: Cache results for offline access.
