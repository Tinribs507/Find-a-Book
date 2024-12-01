package com.example.findabook.ui.displays.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.findabook.ui.displays.search.components.DropDownSearchBar
import com.example.findabook.ui.displays.search.components.SearchBar
import com.example.findabook.ui.viewmodel.MainViewModel

@Composable
fun SearchDisplay(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel,
    onSearchClick: () -> Unit = {}
) {
    // Observe state values from the MainViewModel
    val keyWordsQuery by mainViewModel.keyWordsQuery.observeAsState("")
    val titleQuery by mainViewModel.titleQuery.observeAsState("")
    val authorQuery by mainViewModel.authorQuery.observeAsState("")
    val publisherQuery by mainViewModel.publisherQuery.observeAsState("")
    val subjectQuery by mainViewModel.subjectQuery.observeAsState("")

    // Main container for the search display UI
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 33.dp, start = 8.dp, end = 8.dp)
            .background(Color.White)
    ) {
        // DropDown search bar for keywords and selected option
        DropDownSearchBar(
            text = keyWordsQuery,
            placeHolder = "Key words",
            onValueChange = { mainViewModel.updateKeyWordsQuery(it) },
            onSelectedOptionChange = { mainViewModel.updateSelectedOption(it) },
            clearText = { mainViewModel.updateKeyWordsQuery("") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Search bar for book title
        SearchBar(
            text = titleQuery,
            placeHolder = "Books with the title",
            onValueChange = { mainViewModel.updateTitleQuery(it) },
            clearText = { mainViewModel.updateTitleQuery("") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Search bar for author
        SearchBar(
            text = authorQuery,
            placeHolder = "Books written by",
            onValueChange = { mainViewModel.updateAuthorQuery(it) },
            clearText = { mainViewModel.updateAuthorQuery("") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Search bar for publisher
        SearchBar(
            text = publisherQuery,
            placeHolder = "Books published by",
            onValueChange = { mainViewModel.updatePublisherQuery(it) },
            clearText = { mainViewModel.updatePublisherQuery("") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Search bar for subject
        SearchBar(
            text = subjectQuery,
            placeHolder = "Books on subject",
            onValueChange = { mainViewModel.updateSubjectQuery(it) },
            clearText = { mainViewModel.updateSubjectQuery("") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Button to initiate search
        Button(
            modifier = modifier.fillMaxWidth(),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp,
                pressedElevation = 16.dp,
            ),
            onClick = {
                mainViewModel.fetchBooks()
                onSearchClick()
            }
        ) {
            Text("Find a Book")
        }
    }
}
