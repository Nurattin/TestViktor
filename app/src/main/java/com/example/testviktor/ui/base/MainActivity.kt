package com.example.testviktor.ui.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import com.example.testviktor.ui.base.component.AppScreen
import com.example.testviktor.ui.theme.Dark300
import com.example.testviktor.ui.theme.TestViktorTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestViktorTheme {
                val systemUiController = rememberSystemUiController()
                val darkTheme = isSystemInDarkTheme()
                DisposableEffect(systemUiController) {
                    systemUiController.setSystemBarsColor(
                        color = if (darkTheme) Dark300 else Color.White,
                        darkIcons = !darkTheme
                    )
                    onDispose {}
                }
                AppScreen()
            }
        }
    }
}