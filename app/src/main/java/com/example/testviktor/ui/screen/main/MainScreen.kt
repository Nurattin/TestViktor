package com.example.testviktor.ui.screen.main

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import com.example.testviktor.ui.base.component.LinkText
import com.example.testviktor.ui.base.component.ShowMoreButton
import com.example.testviktor.ui.base.route.ScreenRoute
import com.example.testviktor.ui.screen.main.components.*
import com.example.testviktor.ui.theme.DividerDark
import com.example.testviktor.ui.theme.DividerLight
import com.example.testviktor.ui.theme.LinkTextDark
import com.example.testviktor.ui.theme.LinkTextLight
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel,
    navController: NavHostController
) {
    val darkTheme = isSystemInDarkTheme()
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsState()
    val pagerState = rememberPagerState()

    LazyColumn {
        item { TopAppBar() }
        item {
            TopBarButtons(
                titleWeather = uiState.weatherButton.temperature,
                onClickWeather = {
                    val url = uiState.weatherButton.weatherUrl
                    if (url.isNotEmpty()) {
                        val browserUri = Uri.parse(url)
                        val browserIntent = Intent(Intent.ACTION_VIEW, browserUri)
                        startActivity(context, browserIntent, null)
                    }
                },
                onClickPlace = {
                    val url = uiState.routeButton.routeUrl
                    if (url.isNotEmpty()) {
                        val gmmIntentUri = Uri.parse("geo:${url}")
                        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                        mapIntent.setPackage("com.google.android.apps.maps")
                        startActivity(context, mapIntent, null)
                    }
                }
            )
        }
        item { Spacer(modifier = Modifier.height(24.dp)) }
        item {
            Heading(
                modifier = Modifier.padding(start = 16.dp),
                title = "Домики и номера"
            )
        }
        item { Spacer(modifier = Modifier.height(8.dp)) }
        if (uiState.roomsState.roomsList.isEmpty()) {
            items(count = 5) {
                SmallHorizontalLoadingAnimation()
            }
        } else {
            val roomsList = uiState.roomsState.roomsList
            items(
                items = if (roomsList.size > 5 && !uiState.roomsState.showAll) roomsList.take(5)
                else roomsList
            ) { room ->
                Column {
                    SmallHorizontalCard(
                        title = room.title,
                        price = room.price.factPrice,
                        duration = room.duration.night,
                        imageUrl = room.image.sm,
                        countTourist = room.countTourist
                    )
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth(0.73f)
                            .align(End),
                        color = if (darkTheme) DividerDark else DividerLight
                    )
                }
            }
        }
        if (!uiState.roomsState.showAll) {
            item() {
                ShowMoreButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onClick = { viewModel.showAllRooms() }
                )
            }
        }
        item { Spacer(modifier = Modifier.height(24.dp)) }
        item {
            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = if (darkTheme) DividerDark else DividerLight
            )
        }
        item { Spacer(modifier = Modifier.height(8.dp)) }
        if (uiState.forKidsList.isNotEmpty()) {
            item {
                HorizontalPager(
                    count = uiState.forKidsList.size,
                    state = pagerState
                ) { index ->
                    val item = uiState.forKidsList[index]
                    Banner(
                        imageUrl = item.image.lg,
                        title = item.title
                    )
                }
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Center
                ) {
                    HorizontalPagerIndicator(
                        modifier = Modifier,
                        pagerState = pagerState,
                        indicatorShape = RoundedCornerShape(16.dp),
                        indicatorWidth = 8.dp,
                        indicatorHeight = 4.dp,
                        activeColor = if (darkTheme) LinkTextDark else LinkTextLight,
                        spacing = 4.dp
                    )
                }

            }
        }
        item { Spacer(modifier = Modifier.height(24.dp)) }
        item {
            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = if (darkTheme) DividerDark else DividerLight
            )
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Heading(title = "Места")
                LinkText(text = "Все (20)")
            }
        }
        item {
            LazyRow(
                contentPadding = PaddingValues(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 24.dp
                ),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(items = uiState.placesList) { place ->
                    SmallHorizontalCardFill(
                        modifier = Modifier.width(304.dp),
                        title = place.title,
                        imageUrl = place.image.sm,
                        subtitle = place.subtitle
                    )
                }
            }
        }
        item {
            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = if (darkTheme) DividerDark else DividerLight
            )
        }
        item { Spacer(modifier = Modifier.height(24.dp)) }
        item {
            Heading(
                modifier = Modifier.padding(start = 16.dp),
                title = "Туры"
            )
        }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        item {
            val itemSize: Dp = (LocalConfiguration.current.screenWidthDp.dp / 2) - 20.dp
            FlowRow(
                modifier = Modifier.padding(horizontal = 16.dp),
                mainAxisSize = SizeMode.Expand,
                mainAxisAlignment = FlowMainAxisAlignment.SpaceBetween,
                crossAxisSpacing = 16.dp,
            ) {
                uiState.toursList.forEach { tour ->
                    SmallVerticalCard(
                        width = itemSize,
                        title = tour.title,
                        price = tour.price.price,
                        imageUrl = tour.image.md,
                        type = tour.price.currency
                    )
                }

            }
        }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        item() {
            ShowMoreButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }
        item { Spacer(modifier = Modifier.height(24.dp)) }
        item {
            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = if (darkTheme) DividerDark else DividerLight
            )
        }
        item { Spacer(modifier = Modifier.height(8.dp)) }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Heading(title = "Блоги")
                LinkText(text = "Все (20)")
            }
        }
        item {
            LazyRow(
                contentPadding = PaddingValues(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 24.dp
                ),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(items = uiState.blogList) { blog ->
                    BigHorizontalCardFill(
                        title = blog.title,
                        imageUrl = blog.image.md,
                        subTitle = blog.subtitle,
                        onClick = {
                            navController.navigate(ScreenRoute.DetailBlog.passBlogId(blog.id))
                        }
                    )
                }
            }
        }
    }
}