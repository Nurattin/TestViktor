package com.example.testviktor.ui.screen.blog_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mappa.data.result.Result
import com.example.mappa.data.result.asSuccess
import com.example.testviktor.domain.use_case.GetBlogByIdUseCase
import com.example.testviktor.ui.base.route.DETAIL_BLOG_ARGUMENT
import com.example.testviktor.ui.screen.blog_detail.state.BlogDetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BlogDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val getBlogByIdUseCase: GetBlogByIdUseCase
) : ViewModel() {
    private val blogId: Int = checkNotNull(savedStateHandle[DETAIL_BLOG_ARGUMENT])

    private var _uiState = MutableStateFlow(BlogDetailUiState())
    val uiState: StateFlow<BlogDetailUiState> = _uiState

    init {
        viewModelScope.launch {
            when (val blogDetail = getBlogByIdUseCase(blogId = blogId)) {
                is Result.Failure<*> -> {}

                is Result.Loading -> {}

                is Result.Success -> {
                    blogDetail.asSuccess().value.data.let {
                        _uiState.value = _uiState.value.copy(
                            blogImageUrl = it.image.lg,
                            blogDate = it.date,
                            blogDescriptor = it.content,
                            blogTitle = it.title
                        )
                    }
                }
            }
        }
    }
}