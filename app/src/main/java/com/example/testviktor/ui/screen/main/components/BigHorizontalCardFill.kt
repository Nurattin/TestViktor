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
fun BigHorizontalCardFill(
    modifier: Modifier = Modifier
) {
    val darkTheme = isSystemInDarkTheme()
    val screenWidthDp = LocalConfiguration.current.screenWidthDp.dp

    Card(
        modifier = modifier
            .width(304.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(
            width = 1.dp,
            color = if (darkTheme) BorderImageDark else BorderImageLight
        ),
        elevation = 3.dp
    ) {
        Column(

        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                model = "https://img5.goodfon.ru/wallpaper/nbig/9/18/olen-olenenok-malysh-trava.jpg",
                contentDescription = null,
                placeholder = painterResource(id = R.drawable.ic_baseline_image),
                contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                text = "20 июля",
                fontFamily = FontFamily(Font(R.font.roboto_light, FontWeight.Light)),
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colors.onSurface,
                lineHeight = 24.sp,
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                text = "Встреча с оленёнком Бемби в Cафари парке «Дикая природа»",
                fontFamily = FontFamily(Font(R.font.roboto_medium, FontWeight.Medium)),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colors.onSurface,
                lineHeight = 24.sp,
            )

        }
    }

}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, backgroundColor = 240)
@Preview(showBackground = true)
@Composable
private fun BigHorizontalCardFillPreview() {
    TestViktorTheme() {
        BigHorizontalCardFill()
    }
}