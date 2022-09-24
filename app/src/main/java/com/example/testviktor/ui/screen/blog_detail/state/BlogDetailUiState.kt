package com.example.testviktor.ui.screen.blog_detail.state

import androidx.compose.runtime.Immutable

@Immutable
data class BlogDetailUiState(
    val blogImageUrl: String = "",
    val blogTitle: String = "",
    val blogDescriptor: String = "",
    val blogDate: String = ""
)