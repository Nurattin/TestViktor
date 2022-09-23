package com.example.testviktor.ui.base.route

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testviktor.ui.screen.main.MainScreen
import com.example.testviktor.ui.screen.main.MainViewModel


@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = BottomNavigationBar.Main.route
    ) {
        composable(route = BottomNavigationBar.Main.route) {
            val mainViewModel = hiltViewModel<MainViewModel>()
            MainScreen(viewModel = mainViewModel)
        }
        composable(route = BottomNavigationBar.MapSearch.route) {

        }
        composable(route = BottomNavigationBar.Brooking.route) {

        }
        composable(route = BottomNavigationBar.More.route) {

        }
        composable(route = BottomNavigationBar.Chat.route) {

        }
    }
}