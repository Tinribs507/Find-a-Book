package com.example.findabook.ui.displays.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter

@Composable
fun LoadImageFromUrl(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    val secureUrl = imageUrl.replace("http://", "https://")
    Image(
        painter = rememberAsyncImagePainter(secureUrl),
        contentDescription = "Book cover image",
        contentScale = ContentScale.Fit,
        alignment = Alignment.Center,
        modifier = modifier
    )
}