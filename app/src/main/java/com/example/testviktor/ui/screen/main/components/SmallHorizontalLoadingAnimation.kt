package com.example.testviktor.ui.screen.main.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.testviktor.ui.base.component.LoadingAnimation

@Composable
fun SmallHorizontalLoadingAnimation(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        LoadingAnimation(
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8.dp))
        )

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            LoadingAnimation(
                modifier = modifier
                    .width(110.dp)
                    .height(20.dp)
            )
            Spacer(modifier = Modifier.height(2.dp))
            LoadingAnimation(
                modifier = modifier
                    .width(150.dp)
                    .height(20.dp)
            )
            Spacer(modifier = Modifier.height(2.dp))
            LoadingAnimation(
                modifier = modifier
                    .width(90.dp)
                    .height(20.dp)
            )
        }
    }
}