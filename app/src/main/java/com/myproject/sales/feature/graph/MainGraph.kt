package com.myproject.sales.feature.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.myproject.sales.navigation.ScreenRoute
import com.myproject.sales.screens.dicvory.DiscoverScreen
import com.myproject.sales.screens.home.HomeScreen
import com.myproject.sales.screens.settings.SettingsScreen

fun NavGraphBuilder.mainGraph() {

    composable(ScreenRoute.Home.route) {
        HomeScreen()
    }

    composable(ScreenRoute.Discover.route) {
        DiscoverScreen()
    }

    composable(ScreenRoute.Settings.route) {
        SettingsScreen()
    }
}