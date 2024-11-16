package com.example.findabook.displays.results.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.findabook.data.model.Book

@Composable
fun BookSummaryCard(book: Book, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text =
                buildAnnotatedString {
                    append("Title: ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(book.title)
                    }
                },
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(Modifier.height(4.dp))
            Text(text = "Author: ${book.authors}")
            Spacer(Modifier.height(4.dp))
            Text(text = "Publisher: ${book.publisher}")
            Spacer(Modifier.height(4.dp))
            Text(text = "Published Date: ${book.publishedDate}")
            Spacer(Modifier.height(4.dp))
            Text(text = "Description: ${book.description}")
        }
    }
}