package com.example.findabook.ui.displays.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.findabook.data.model.Book
import com.example.findabook.data.model.ImageLinks
import com.example.findabook.ui.displays.results.components.BookSummaryCard
import com.example.findabook.ui.theme.FindABookTheme

@Composable
fun RoundedDivider(
    text: String
) {
    val color = DividerDefaults.color
    Box {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text)
        }
        LeftOuterCurve(color)
        LeftInnerCurve(color)
        LeftCenterCurve(color)
        RightOuterCurve(color)
        RightInnerCurve(color)
        RightCenterCurve(color)
    }
}

@Composable
fun LeftOuterCurve(
    color: Color
) {
    Row(verticalAlignment = Alignment.Bottom) {
        Canvas(
            modifier = Modifier
                .size(10.dp),
        ) {
            drawArc(
                color = color,
                80f,
                260f,
                false,
                style = Stroke(3f, cap = StrokeCap.Round),
                size = Size(size.width, size.height)
            )
        }
        Canvas(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            drawLine(color, Offset(-15f, 0f), Offset(size.width / 3, 0f), 3f)
        }
    }
}

@Composable
fun LeftInnerCurve(color: Color) {
    Row(modifier = Modifier.padding(start = 1.9.dp)) {
        Canvas(
            modifier = Modifier
                .size(8.dp)
                .padding(start = 0.dp),
        ) {
            drawArc(
                color = color,
                270f,
                260f,
                false,
                style = Stroke(3f, cap = StrokeCap.Round),
                size = Size(size.width, size.height)
            )
        }
    }
}

@Composable
fun LeftCenterCurve(color: Color) {
    Row(modifier = Modifier.padding(start = 2.dp)) {
        Canvas(
            modifier = Modifier
                .size(6.dp)
                .padding(end = 1.dp, top = 2.dp),
        ) {
            drawArc(
                color = color,
                180f,
                260f,
                false,
                style = Stroke(2f, cap = StrokeCap.Round),
                size = Size(size.width, size.height)
            )
        }
    }
}

@Composable
fun RightOuterCurve(
    color: Color
) {
    Row(verticalAlignment = Alignment.Bottom) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth().weight(1f),
        ) {
            drawLine(color, Offset(620f, 0f), Offset(size.width + 15, 0f), 3f)
        }
        Canvas(
            modifier = Modifier
                .size(10.dp),
        ) {
            drawArc(
                color = color,
                200f,
                260f,
                false,
                style = Stroke(3f, cap = StrokeCap.Round),
                size = Size(size.width, size.height)
            )
        }
    }
}

@Composable
fun RightInnerCurve(color: Color) {
    Row(modifier = Modifier.fillMaxWidth().padding(end = 1.9.dp), horizontalArrangement = Arrangement.End) {
        Canvas(
            modifier = Modifier
                .size(8.dp)
                .padding(start = 0.dp),
        ) {
            drawArc(
                color = color,
                30f,
                260f,
                false,
                style = Stroke(3f, cap = StrokeCap.Round),
                size = Size(size.width, size.height)
            )
        }
    }
}

@Composable
fun RightCenterCurve(color: Color) {
        Row(modifier = Modifier.fillMaxWidth().padding(end = 2.dp), horizontalArrangement = Arrangement.End) {
            Canvas(
                modifier = Modifier
                    .size(6.dp)
                    .padding(start = 1.dp, top = 2.dp),
            ) {
                drawArc(
                    color = color,
                    140f,
                    260f,
                    false,
                    style = Stroke(2f, cap = StrokeCap.Round),
                    size = Size(size.width, size.height),
                    topLeft = Offset(0.7f, 0.7f)
                )
            }
        }

}

@Preview(showBackground = true)
@Composable
fun BookSummaryCardPreview() {
    val imageLinks = ImageLinks(
        thumbnail = "https://books.google.com/books/content?id=WpD_DAAAQBAJ&printsec=frontcover&img=1&zoom=3&edge=curl&source=gbs_api",
    )
    val book = Book(
        title = "The Great Gatsby",
        authors = listOf("F. Scott Fitzgerald"),
        publisher = "Scribner",
        publishedDate = "1925",
        description = "The Great Gatsby is a novel written by American author F. Scott Fitzgerald that tells the story of the fabulously wealthy Jay Gatsby and his love for the beautiful Daisy Buchanan.",
        imageLinks = imageLinks
    )
    FindABookTheme { BookSummaryCard(book) }
}
