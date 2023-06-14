package com.myproject.sales.feature.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.myproject.sales.navigation.ScreenRoute
import com.myproject.sales.screens.dicvory.DiscoverScreen
import com.myproject.sales.screens.home.HomeScreen

fun NavGraphBuilder.mainGraph() {
    val homeRoute = ScreenRoute.Home.route
    val discovery = ScreenRoute.Discover.route

    composable(ScreenRoute.Home.route) {
        HomeScreen()
    }

    composable(ScreenRoute.Discover.route) {
        DiscoverScreen()
    }
}

object MainNav {
    const val MAIN_HOME_SCREEN = "home_screen"
}
