package com.example.testviktor.ui.screen.main.components

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.testviktor.R
import com.example.testviktor.ui.theme.BorderImageDark
import com.example.testviktor.ui.theme.BorderImageLight
import com.example.testviktor.ui.theme.TestViktorTheme

@Composable
fun Banner(
    modifier: Modifier = Modifier,
    imageUrl: String,
    title: String
) {
    val darkTheme = isSystemInDarkTheme()
    val itemSize = LocalConfiguration.current.screenWidthDp.dp

    Column(
        modifier = modifier
            .width(itemSize)
            .padding(horizontal = 16.dp, vertical = 24.dp),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(itemSize-32.dp),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(
                width = 1.dp,
                color = if (darkTheme) BorderImageDark else BorderImageLight
            )
        ) {
            AsyncImage(
                modifier = Modifier,
                model = imageUrl,
                contentDescription = null,
                placeholder = painterResource(id = R.drawable.ic_baseline_image),
                contentScale = ContentScale.FillBounds
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "20 июля",
            fontFamily = FontFamily(Font(R.font.roboto_light, FontWeight.Light)),
            fontSize = 16.sp,
            fontWeight = FontWeight.Light,
            color = MaterialTheme.colors.onSurface,
            lineHeight = 24.sp,
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = title,
            fontFamily = FontFamily(Font(R.font.roboto_medium, FontWeight.Medium)),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colors.onSurface,
            lineHeight = 24.sp,
            maxLines = 1
        )

    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, backgroundColor = 240)
@Preview(showBackground = true)
@Composable
private fun BigHorizontalCardPreview() {
    TestViktorTheme() {
        Banner(
            imageUrl = "",
            title = "Встреча с оленёнком Бемби в Cафари парке «Дикая природа»"
        )
    }
}