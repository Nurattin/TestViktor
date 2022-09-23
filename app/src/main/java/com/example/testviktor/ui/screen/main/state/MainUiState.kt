package com.example.testviktor.ui.screen.main.state

import com.example.testviktor.data.model.Rooms

data class MainUiState(
    val weatherButton: WeatherButtonState = WeatherButtonState(),
    val routeButton: RouteButtonState = RouteButtonState(),
    val roomsState: RoomState = RoomState()
) {
    data class WeatherButtonState(
        val temperature: String = "",
        val weatherUrl: String = "",
    )

    data class RouteButtonState(
        val routeUrl: String = "",
    )
    data class RoomState(
        val roomsList: List<Rooms.Data> = emptyList(),
        val showAll: Boolean = false
    )
}