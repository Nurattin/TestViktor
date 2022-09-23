package com.example.testviktor.ui.base.component

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testviktor.R
import com.example.testviktor.ui.theme.*


@Composable
fun ShowMoreButton(
    modifier: Modifier = Modifier,
    onClick: ()->Unit = {}
) {
    val darkTheme = isSystemInDarkTheme()

    OutlinedButton(
        modifier = modifier,
        onClick = { onClick() },
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, color = if (darkTheme) LinkBorderDark else LinkBorderLight),
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = if (darkTheme) LinkBackgroundDark else LinkBackgroundLight
        ),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        Text(
            text = "Показать все (20)",
            fontFamily = FontFamily(Font(R.font.roboto_medium, FontWeight.Medium)),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = if (darkTheme) LinkTextDark else LinkTextLight,
            lineHeight = 24.sp,
        )

    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, backgroundColor = 230)
@Preview(showBackground = true)
@Composable
private fun ShowMoreButtonPreview() {
    TestViktorTheme() {
        ShowMoreButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {}
        )
    }
}