package com.example.findabook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.findabook.displays.results.ResultsDisplay
import com.example.findabook.displays.search.SearchDisplay
import com.example.findabook.ui.theme.FindABookTheme
import com.example.findabook.ui.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FindABookTheme {
                val navController = rememberNavController()
                val mainViewModel = MainViewModel()
                // Observe the list of books from the ViewModel
                val bookList by mainViewModel.books.observeAsState(emptyList())
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Define the NavHost with the navigation graph
                    NavHost(navController, startDestination = "searchDisplay") {
                        composable("searchDisplay") {
                            // Composable for the search display screen
                            SearchDisplay(
                                modifier = Modifier.padding(innerPadding),
                                mainViewModel = mainViewModel,
                                onSearchClick = {
                                    // Navigate to the results display screen on search
                                    navController.navigate("resultsDisplay")
                                }
                            )
                        }
                        // Composable for the results display screen
                        composable("resultsDisplay") {
                            ResultsDisplay(bookList)
                        }
                    }
                }
            }
        }
    }
}