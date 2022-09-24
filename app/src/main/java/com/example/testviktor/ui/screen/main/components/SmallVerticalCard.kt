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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.testviktor.R
import com.example.testviktor.ui.theme.BorderImageDark
import com.example.testviktor.ui.theme.BorderImageLight
import com.example.testviktor.ui.theme.TestViktorTheme


@Composable
fun SmallVerticalCard(
    width: Dp,
    modifier: Modifier = Modifier,
    price: Int,
    type: String,
    imageUrl: String,
    title: String
) {
    val height = width * 0.65f
    Column(
        modifier = modifier.width(width),
    ) {
        Card(
            modifier = Modifier
                .height(height),

            border = BorderStroke(
                width = 1.dp,
                color = if (isSystemInDarkTheme()) BorderImageDark else BorderImageLight
            ),
            shape = RoundedCornerShape(8.dp),
            elevation = 0.dp
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = imageUrl,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                placeholder = painterResource(id = R.drawable.ic_baseline_image),
                error = painterResource(id = R.drawable.ic_placeholder)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = title,
            fontFamily = FontFamily(Font(R.font.roboto, FontWeight.Normal)),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colors.onSurface,
            lineHeight = 16.sp,
            maxLines = 1
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.onSurface,
                    fontFamily = FontFamily(Font(R.font.roboto, FontWeight.Normal)),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                )
            ) {
                append("$price")
            }
            append(" ")
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.onSurface,
                    fontFamily = FontFamily(Font(R.font.roboto, FontWeight.Normal)),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                )
            ) {
                append(type)
            }
        })
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, backgroundColor = 256)
@Preview(showBackground = true)
@Composable
private fun SmallVerticalCardPreview() {
    TestViktorTheme() {
        SmallVerticalCard(
            width = 160.dp,
            title = "Автотур \"Океан\" Андреевка Молодежная 5 дней",
            price = 7320,
            type = "Rub",
            imageUrl = ""
        )
    }
}