package com.example.testviktor.ui.screen.blog_detail.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun BlogImage(
    modifier: Modifier = Modifier,
    imageUrl: String,

) {
    val imageWidth = LocalConfiguration.current.screenWidthDp
    val imageHeight = imageWidth * 0.84

    AsyncImage(
        modifier = modifier
            .height(imageHeight.dp)
            .width(imageWidth.dp),
        model = imageUrl,
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        )
}
