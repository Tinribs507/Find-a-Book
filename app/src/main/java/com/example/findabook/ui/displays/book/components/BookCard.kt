package com.example.findabook.ui.displays.book.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.findabook.data.model.Book
import com.example.findabook.data.model.ImageLinks
import com.example.findabook.ui.displays.components.LoadImageFromUrl

@Composable
fun BookCard(book: Book) {
    OutlinedCard(modifier = Modifier.fillMaxSize(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant),
        ) {
        book.imageLinks?.let { LoadImageFromUrl(it.thumbnail) }
    }
}

@Preview(showBackground = true)
@Composable
fun BookCardPreview() {
    val imageLinks = ImageLinks(
        thumbnail = "https://books.google.com/books/content?id=WpD_DAAAQBAJ&printsec=frontcover&img=1&zoom=3&edge=curl&source=gbs_api",
    )
    val book = Book(
        title = "The Great Gatsby",
        authors = listOf("F. Scott Fitzgerald"),
        publisher = "Scribner",
        publishedDate = "1925",
        description = "The Great Gatsby is a novel written by American author F. Scott Fitzgerald that tells the story of the fabulously wealthy Jay Gatsby and his love for the beautiful Daisy Buchanan.",
        imageLinks = imageLinks)
    BookCard(book)
}