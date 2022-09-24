package com.example.testviktor.ui.screen.blog_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testviktor.R
import com.example.testviktor.ui.screen.blog_detail.components.BlogImage
import com.example.testviktor.ui.screen.blog_detail.components.ComeBackButton
import com.example.testviktor.ui.theme.TextRemovedLight

@Composable
fun BlogDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: BlogDetailViewModel,
    navController: NavHostController
) {

    val uiState by viewModel.uiState.collectAsState()
    val scrollState = rememberScrollState()

    if (uiState.blogDescriptor.isNotEmpty()) {
        Column(
            modifier = modifier.verticalScroll(scrollState)
        ) {
            Box(
                modifier = Modifier
            ) {
                BlogImage(
                    imageUrl = uiState.blogImageUrl)
                ComeBackButton(
                    modifier = Modifier.padding(top = 44.dp, start = 20.dp),
                    onClick = { navController.popBackStack() })

            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                text = uiState.blogDate,
                fontFamily = FontFamily(Font(R.font.roboto, FontWeight.Normal)),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = TextRemovedLight,
                lineHeight = 16.sp,
            )

            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                text = uiState.blogTitle,
                fontFamily = FontFamily(Font(R.font.roboto_bold, FontWeight.Bold)),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onSurface,
                lineHeight = 28.8.sp,
            )

            Spacer(modifier = Modifier.height(16.dp))
            Divider(modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                text = uiState.blogDescriptor,
                fontFamily = FontFamily(Font(R.font.roboto, FontWeight.Normal)),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colors.onSurface,
                lineHeight = 24.sp,
            )
        }
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                strokeWidth = 1.dp,
                color = MaterialTheme.colors.onSurface
            )
        }
    }
}