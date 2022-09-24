package com.example.testviktor.ui.screen.main.state

import com.example.testviktor.data.model.*

data class MainUiState(
    val weatherButton: WeatherButtonState = WeatherButtonState(),
    val routeButton: RouteButtonState = RouteButtonState(),
    val roomsState: RoomState = RoomState(),
    val forKidsList: List<Child.Data> = emptyList(),
    val toursList: List<Tours.Data> = emptyList(),
    val entertainmentList: List<Entertainment.Data> = emptyList(),
    val blogList: List<Blog.Data> = emptyList(),
    val foodsList: List<Foods.Data> = emptyList(),
    val placesList: List<Place.Data> = emptyList()
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