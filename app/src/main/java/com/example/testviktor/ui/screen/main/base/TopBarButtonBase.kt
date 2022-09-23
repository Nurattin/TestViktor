package com.example.testviktor.ui.screen.main.base

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testviktor.R


@Composable
fun GradientButton(
    @DrawableRes icon: Int,
    text: String,
    gradient: Brush,
    onClick: () -> Unit,
    enable: Boolean = true,
    showProgressBar: Boolean = false
) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(),
        enabled = enable
    ) {
        Row(
            modifier = Modifier
                .background(brush = gradient)
                .padding(horizontal = 11.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = Color.White
            )
            if (showProgressBar) {
                CircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    strokeWidth = 1.dp,
                    color = MaterialTheme.colors.onSurface
                )
            } else {
                Text(
                    text = text,
                    fontFamily = FontFamily(Font(R.font.roboto, FontWeight.Normal)),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    lineHeight = 20.sp,
                )
            }
        }
    }
}