package com.myproject.sales.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.myproject.sales.R

sealed class NavigationBarSection(
    @StringRes val title: Int,
    val icon: ImageVector,
    val route: String,
) {
    object Home : NavigationBarSection(
        title = R.string.bottom_nav_home,
        icon = Icons.Filled.Home,
        route = ScreenRoute.Home.route,
    )

    object Discover : NavigationBarSection(
        title = R.string.bottom_nav_discover,
        icon = Icons.Filled.Search,
        route = ScreenRoute.Discover.route,
    )

    object Settings : NavigationBarSection(
        title = R.string.bottom_nav_settings,
        icon = Icons.Filled.Settings,
        route = ScreenRoute.Menu.route,
    )

    companion object {
        val sections = listOf(Home, Discover, Settings)
    }
}
