package com.example.findabook.ui.displays.results.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.findabook.data.model.Book
import com.example.findabook.ui.displays.components.LoadImageFromUrl

@Composable
fun BookSummaryCard(book: Book, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            book.title?.let {
                Text(
                    text = it,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                )
            }
            book.imageLinks?.let {
                LoadImageFromUrl(
                    it.smallThumbnail,
                    modifier = Modifier.fillMaxWidth().size(150.dp)
                )
                Spacer(Modifier.height(10.dp))
            }
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Author")
                Text(text = book.authors.toString(), fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(10.dp))
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Publisher")
                Text(text = book.publisher.toString(), fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(10.dp))
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Published Date")
                Text(text = book.publishedDate.toString(), fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(10.dp))
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = book.description, fontWeight = FontWeight.Bold)
            }
        }
    }
}