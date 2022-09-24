package com.example.testviktor.ui.screen.main.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.testviktor.ui.theme.TextColorLight
import com.example.testviktor.ui.theme.TextRemovedLight
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.fade
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer

@Composable
fun SmallHorizontalLoadingAnimation(
    modifier: Modifier = Modifier

) {
    Row(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8.dp))
                .placeholder(
                    visible = true,
                    color = TextRemovedLight,
                    shape = RoundedCornerShape(4.dp),
                    highlight = PlaceholderHighlight.shimmer(
                        highlightColor = Color.White,
                    ),
                )
        )

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = modifier
                    .width(110.dp)
                    .height(20.dp)
                    .placeholder(
                        visible = true,
                        color = TextRemovedLight,
                        shape = RoundedCornerShape(4.dp),
                        highlight = PlaceholderHighlight.shimmer(
                            highlightColor = Color.White,
                        ),
                    )
            )
            Spacer(modifier = Modifier.height(2.dp))
            Box(
                modifier = modifier
                    .width(150.dp)
                    .height(20.dp)
                    .placeholder(
                        visible = true,
                        color = TextRemovedLight,
                        // optional, defaults to RectangleShape
                        shape = RoundedCornerShape(4.dp),
                        highlight = PlaceholderHighlight.shimmer(
                            highlightColor = Color.White,
                        ),
                    )
            )
            Spacer(modifier = Modifier.height(2.dp))
            Box(
                modifier = modifier
                    .width(90.dp)
                    .height(20.dp)
                    .placeholder(
                        visible = true,
                        color = TextRemovedLight,
                        shape = RoundedCornerShape(4.dp),
                        highlight = PlaceholderHighlight.shimmer(
                            highlightColor = Color.White,
                        ),
                    )
            )
        }
    }
}