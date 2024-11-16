package com.example.findabook.displays.search.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

/**
 * A composable function that combines a search bar with a dropdown menu for search options.
 *
 * @param value The current text in the search bar.
 * @param placeHolder The placeholder text for the searchbar.
 * @param onValueChange A function to call when the search bar value changes.
 * @param onSelectedOptionChange A function to call when a dropdown option is selected
 */
@Composable
fun DropDownSearchBar(
    value: String,
    placeHolder: String,
    onValueChange: (String) -> Unit,
    onSelectedOptionChange: (String) -> Unit
) {
    // State to track whether the dropdown menu is expanded
    var expanded by remember { mutableStateOf(false) }

    // List of options for the dropdown menu
    val options = listOf(
        "With all words",
        "Exact phrase",
        "With at least one",
        "Without the words"
    )

    // Row to hold the search bar and dropdown menu icon
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // Search bar with a trailing icon to expand the dropdown menu
        SearchBar(
            modifier = Modifier.weight(1f),
            value = value,
            placeHolder = placeHolder,
            trailingIcon = {
                IconButton(
                    onClick = { expanded = !expanded }
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = null
                    )
                }
            },
            onValueChange = { onValueChange(it) }
        )

        // Dropdown menu that appears when the trailing icon is clicked
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(text = option) },
                    onClick = {
                        onSelectedOptionChange(option)
                        expanded = false // Close the dropdown menu after selecting an option
                    },
                )
            }
        }
    }
}