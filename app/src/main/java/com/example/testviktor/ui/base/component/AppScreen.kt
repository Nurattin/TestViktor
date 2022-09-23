package com.example.testviktor.ui.base.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testviktor.ui.base.route.NavGraph

@Composable
fun AppScreen() {
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentScreen = currentBackStack?.destination
    var bottomBarIsShow by remember { mutableStateOf(false) }

//    LaunchedEffect(key1 = currentScreen) {
//        if (currentScreen != null && bottomBarIsShow != BottomNavigationBar.any { (it.route == currentScreen.route) }) {
//            bottomBarIsShow = !bottomBarIsShow
//        }
//    }

    Scaffold(
        bottomBar = {
            BottomNavigationBarScreen(
                navController = navController,
                currentScreen = currentScreen
            )
        }
    ) { innerPadding ->
        NavGraph(
            modifier = Modifier
                .padding(innerPadding),
            navController = navController
        )
    }
}