package com.example.testviktor.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mappa.data.result.Result
import com.example.mappa.data.result.asSuccess
import com.example.testviktor.domain.use_case.GetBlogUseCase
import com.example.testviktor.domain.use_case.GetMainUseCase
import com.example.testviktor.domain.use_case.GetRoomUseCase
import com.example.testviktor.ui.screen.main.state.MainUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getBlogUseCase: GetBlogUseCase,
    private val getRoomUseCase: GetRoomUseCase,
    private val getMainUseCase: GetMainUseCase,
) : ViewModel() {

    private var _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState

    init {
        viewModelScope.launch {
            when (val mainData = getMainUseCase()) {

                is Result.Failure<*> -> {}

                is Result.Loading -> {}

                is Result.Success -> {
                    mainData.asSuccess().value.data.buttons.let { button ->
                        _uiState.value = _uiState.value.copy(
                            routeButton = MainUiState.RouteButtonState(
                                routeUrl = button.last().url
                            ),
                            weatherButton = MainUiState.WeatherButtonState(
                                temperature = button.first().title,
                                weatherUrl = button.first().url
                            ),
                        )
                    }
                }
            }
            when (val roomsList = getRoomUseCase()) {
                is Result.Failure<*> -> {}

                is Result.Loading -> {}

                is Result.Success -> {
                    roomsList.asSuccess().value.data.let {
                        _uiState.value = _uiState.value.copy(
                            roomsState = MainUiState.RoomState(
                                roomsList = it
                            )
                        )
                    }
                }
            }
        }
    }

    fun showAllRooms() {
        _uiState.value = uiState.value.copy(
            roomsState = uiState.value.roomsState.copy(
                showAll = true
            )
        )
    }
}