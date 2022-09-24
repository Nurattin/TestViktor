package com.example.testviktor.ui.screen.main.components


import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.testviktor.R
import com.example.testviktor.ui.theme.BorderImageDark
import com.example.testviktor.ui.theme.BorderImageLight
import com.example.testviktor.ui.theme.TestViktorTheme


@Composable
fun SmallHorizontalCard(
    modifier: Modifier = Modifier,
    imageUrl: String,
    title: String,
    price: Int,
    duration: Int,
    countTourist: Int
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
                onClick = {})
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Card(
            modifier = Modifier.size(80.dp),
            border = BorderStroke(
                width = 1.dp,
                color = if (isSystemInDarkTheme()) BorderImageDark else BorderImageLight
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = imageUrl,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                placeholder = painterResource(id = R.drawable.ic_placeholder),
                error = painterResource(id = R.drawable.ic_placeholder)
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "до $countTourist гостей",
                fontFamily = FontFamily(Font(R.font.roboto, FontWeight.Normal)),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colors.onSurface,
                lineHeight = 20.sp,
                maxLines = 1
            )
            Text(
                text = title,
                fontFamily = FontFamily(Font(R.font.roboto, FontWeight.Normal)),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colors.onSurface,
                lineHeight = 24.sp,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.onSurface,
                        fontFamily = FontFamily(Font(R.font.roboto, FontWeight.Normal)),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                    )
                ) {
                    append("$price")
                }
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.onSurface,
                        fontFamily = FontFamily(Font(R.font.roboto, FontWeight.Normal)),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                    )
                ) {
                    append("/ $duration ночь")
                }
            })
        }
    }
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, backgroundColor = 256)
@Preview(showBackground = true)
@Composable
private fun SmallHorizontalCardPreview() {
    TestViktorTheme() {
        SmallHorizontalCard(
            imageUrl = "",
            title = "Молодёжная",
            price = 2000,
            duration = 2,
            countTourist = 3
        )
    }
}
