package com.example.testviktor.ui.screen.main.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testviktor.R
import com.example.testviktor.ui.screen.main.base.GradientButton
import com.example.testviktor.ui.theme.*


@Composable
fun TopBarButtons(
    onClickWeather: () -> Unit,
    onClickPlace: () -> Unit,
    titleWeather: String,
) {

    val state = rememberScrollState()
    Row(
        modifier = Modifier
            .horizontalScroll(state)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        WeatherButton(
            title = titleWeather,
            onClick = onClickWeather
        )
        HelpButton()
        MapMarkerButton(
            onClick = onClickPlace)
    }
}

@Composable
private fun WeatherButton(
    onClick: () -> Unit,
    title: String,
) {

    val darkTheme = isSystemInDarkTheme()

    GradientButton(
        icon = R.drawable.weather_sunny,
        text = title,
        gradient = Brush.horizontalGradient(
            colors = if (darkTheme) listOf(
                WeatherButtonGradientDark0,
                WeatherButtonGradientDark1
            )
            else listOf(
                WeatherButtonGradientLight0,
                WeatherButtonGradientLight1
            )
        ),
        onClick = { onClick() },
        showProgressBar = title.isEmpty()
    )
}

@Composable
private fun HelpButton(
) {
    val darkTheme = isSystemInDarkTheme()
    GradientButton(
        icon = R.drawable.help_circle_outline,
        text = "О базе отдыха",
        gradient = Brush.horizontalGradient(
            colors = if (darkTheme) listOf(
                AboutButtonGradientDark0,
                AboutButtonGradientDark1
            )
            else listOf(
                AboutButtonGradientLight0,
                AboutButtonGradientLight1
            )
        ),
        onClick = {})
}

@Composable
private fun MapMarkerButton(
    onClick: () -> Unit
) {
    val darkTheme = isSystemInDarkTheme()
    GradientButton(
        icon = R.drawable.map_marker_path,
        text = "Как добраться",
        gradient = Brush.horizontalGradient(
            colors = if (darkTheme) listOf(
                RouteButtonGradientDark0,
                RouteButtonGradientDark1
            )
            else listOf(
                RouteButtonGradientLight0,
                RouteButtonGradientLight1
            )
        ),
        onClick = {
            onClick()
        })
}

@Preview
@Composable
private fun TopBarButtonPreview() {
    TestViktorTheme() {
        TopBarButtons(
            onClickWeather = {},
            onClickPlace = {},
            titleWeather = "+29"
        )
    }
}