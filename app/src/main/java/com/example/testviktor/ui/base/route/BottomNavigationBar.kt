package com.example.testviktor.ui.base.route

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.testviktor.R

private const val MAIN = "main"
private const val MAP_SEARCH = "map_search"
private const val BOOKING = "broking"
private const val CHAT = "chat"
private const val MORE = "more"

sealed class BottomNavigationBar(
    val route: String,
    @DrawableRes val icon: Int,
    @StringRes val title: Int
) {
    object Main : BottomNavigationBar(
        route = MAIN,
        icon = R.drawable.ic_home,
        title = R.string.main,
    )

    object MapSearch : BottomNavigationBar(
        route = MAP_SEARCH,
        icon = R.drawable.ic_map_search_outline,
        title = R.string.map,
    )

    object Brooking : BottomNavigationBar(
        route = BOOKING,
        icon = R.drawable.ic_shopping_outline,
        title = R.string.brooking,
    )

    object Chat : BottomNavigationBar(
        route = CHAT,
        icon = R.drawable.ic_comments,
        title = R.string.chat,
    )

    object More : BottomNavigationBar(
        route = MORE,
        icon = R.drawable.ic_dots_horizontal,
        title = R.string.more
    )
}

val bottomBarItems = listOf<BottomNavigationBar>(
    BottomNavigationBar.Main,
    BottomNavigationBar.MapSearch,
    BottomNavigationBar.Brooking,
    BottomNavigationBar.Chat,
    BottomNavigationBar.More,
)
