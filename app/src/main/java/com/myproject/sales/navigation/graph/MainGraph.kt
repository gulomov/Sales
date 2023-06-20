package com.myproject.sales.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.myproject.sales.navigation.ScreenRoute
import com.myproject.sales.screens.dicvory.DiscoverScreen
import com.myproject.sales.screens.home.HomeScreen
import com.myproject.sales.screens.menu.MenuScreen
import com.myproject.sales.screens.menu.ProfileScreen

fun NavGraphBuilder.mainGraph(navController: NavController) {

    composable(ScreenRoute.Home.route) {
        HomeScreen()
    }

    composable(ScreenRoute.Discover.route) {
        DiscoverScreen()
    }

    composable(ScreenRoute.Menu.route) {
        MenuScreen(navController)
    }

    composable(ScreenRoute.Profile.route) {
        ProfileScreen(navController)
    }

}