package com.example.testviktor.ui.screen.main.components

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testviktor.R
import com.example.testviktor.ui.theme.TestViktorTheme

@Composable
fun TopAppBar() {
    androidx.compose.material.TopAppBar(
        title = {
            Text(
                text = "Главная",
                fontFamily = FontFamily(Font(R.font.roboto_medium, FontWeight.Medium)),
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colors.onSurface,
                lineHeight = 24.sp,
            )
        },
        backgroundColor = MaterialTheme.colors.background,
        elevation = 0.dp
    )
}

@Preview
@Composable
private fun TopAppBarPreviewLight(
) {
    TestViktorTheme(darkTheme = true) {
        TopAppBar()
    }
}

@Preview()
@Composable
private fun TopAppBarPreviewDark() {
    TestViktorTheme(darkTheme = false) {
        TopAppBar()
    }
}