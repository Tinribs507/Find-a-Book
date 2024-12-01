package com.example.findabook.ui.displays.search.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * A composable function that represents a search bar with an optional trailing icon.
 *
 * @param modifier The modifier to be applied to the TextField.
 * @param text The current text in the search bar.
 * @param placeHolder The placeholder text for the searchbar.
 * @param trailingIcon An optional trailing icon composable.
 * @param onValueChange A function to call when the search bar value changes.
 */
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    text: String,
    placeHolder: String,
    trailingIcon: @Composable () -> Unit? = {},
    onValueChange: (String) -> Unit = {},
    clearText: () -> Unit = {}
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = text,
        onValueChange = { onValueChange(it) },
        textStyle = MaterialTheme.typography.bodyLarge,
        label = {
            Text(
                text = placeHolder,
                color = Color.Black.copy(alpha = 0.4f),
                style = MaterialTheme.typography.bodyLarge
            )
        },
        trailingIcon = {
            if (trailingIcon != {} && text.isNotEmpty() && isFocused) {
                IconButton(
                    onClick = { clearText() }
                ) {
                    Icon(Icons.Filled.Clear, contentDescription = "Clear text")
                }
            } else {
                trailingIcon()
            }
        },
        singleLine = true,
        interactionSource = interactionSource
    )
}