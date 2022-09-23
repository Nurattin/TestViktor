package com.example.testviktor.ui.base.component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.testviktor.R
import com.example.testviktor.ui.theme.LinkTextDark
import com.example.testviktor.ui.theme.LinkTextLight

@Composable
fun LinkText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        fontFamily = FontFamily(Font(R.font.roboto, FontWeight.Normal)),
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        color = if (isSystemInDarkTheme()) LinkTextDark else LinkTextLight,
        lineHeight = 24.sp,
    )
}