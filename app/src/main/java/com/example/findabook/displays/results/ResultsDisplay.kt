package com.example.findabook.displays.results

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.findabook.data.model.Book
import com.example.findabook.displays.results.components.BookSummaryCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultsDisplay(bookList: List<Book>) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = { Text("Book Results") })
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            LazyColumn {
                items(bookList) { book ->
                    BookSummaryCard(book)
                }
            }
        }
    }
}