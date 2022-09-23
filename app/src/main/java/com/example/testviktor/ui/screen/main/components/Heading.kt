package com.example.testviktor.ui.screen.main.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.testviktor.R
import com.example.testviktor.ui.theme.TestViktorTheme

@Composable
fun Heading(
    modifier: Modifier = Modifier,
    title: String
) {
    Text(
        modifier = modifier,
        text = title,
        fontFamily = FontFamily(Font(R.font.roboto, FontWeight.Normal)),
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        color = MaterialTheme.colors.onSurface,
        lineHeight = 28.8.sp,
    )
}

@Preview
@Composable
private fun HeadingPreviewLight() {
    TestViktorTheme(darkTheme = false) {
        Heading(
            title = "Домики и номера",
        )
    }
}

@Preview
@Composable
private fun HeadingPreviewDark() {
    TestViktorTheme(darkTheme = true) {
        Heading(
            title = "Домики и номера",
        )
    }
}