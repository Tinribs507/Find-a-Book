package com.example.findabook.ui.displays.search.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * A composable function that represents a search bar with an optional trailing icon.
 *
 * @param modifier The modifier to be applied to the TextField.
 * @param value The current text in the search bar.
 * @param placeHolder The placeholder text for the searchbar.
 * @param trailingIcon An optional trailing icon composable.
 * @param onValueChange A function to call when the search bar value changes.
 */
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    value: String,
    placeHolder: String,
    trailingIcon: @Composable () -> Unit? = {},
    onValueChange: (String) -> Unit = {}
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = { onValueChange(it) },
        textStyle = MaterialTheme.typography.bodyLarge,
        placeholder = {
            Text(
                text = placeHolder,
                color = Color.Black,
                style = MaterialTheme.typography.bodyLarge
            )
        },
        trailingIcon = {
            trailingIcon()
        },
        singleLine = true,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.LightGray.copy(alpha = 0.5f),
        )
    )
}