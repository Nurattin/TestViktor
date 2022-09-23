package com.example.testviktor.ui.base.component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.testviktor.ui.base.route.BottomNavigationBar
import com.example.testviktor.ui.base.route.bottomBarItems
import com.example.testviktor.ui.theme.BottomBarItemSelectedDark
import com.example.testviktor.ui.theme.BottomBarItemSelectedLight
import com.example.testviktor.ui.theme.BottomBarItemUnSelectedDark
import com.example.testviktor.ui.theme.BottomBarItemUnSelectedLight


@Composable
fun BottomNavigationBarScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    currentScreen: NavDestination?
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 1.dp
    ) {
        bottomBarItems.forEach {
            AddItem(
                item = it,
                selected = currentScreen?.hierarchy?.any { navDestination ->
                    navDestination.route == it.route
                } == true,
                navController = navController)
        }
    }
}

@Composable
private fun RowScope.AddItem(
    modifier: Modifier = Modifier,
    item: BottomNavigationBar,
    selected: Boolean,
    navController: NavHostController
) {

    val darkTheme = isSystemInDarkTheme()

    BottomNavigationItem(
        modifier = modifier,
        icon = {
            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        },
        label = {
            Text(
                text = stringResource(id = item.title),
                style = MaterialTheme.typography.caption
            )
        },
        selected = selected,
        onClick = {
            navController.navigate(item.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        selectedContentColor = if (darkTheme) BottomBarItemSelectedDark else BottomBarItemSelectedLight,
        unselectedContentColor = if (darkTheme) BottomBarItemUnSelectedDark else BottomBarItemUnSelectedLight
    )
}

@Preview
@Composable
fun BottomNavigationBarScreenPreview() {
    BottomNavigationBarScreen(
        navController = rememberNavController(),
        currentScreen = null
    )
}

