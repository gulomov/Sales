package com.myproject.sales.feature.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.myproject.sales.navigation.ScreenRoute
import com.myproject.sales.screens.home.HomeScreen

fun NavGraphBuilder.mainGraph() {
    val homeRoute = ScreenRoute.Home.route
    val discovery = ScreenRoute.Discover.route

    composable(ScreenRoute.Home.route) {
        HomeScreen()
    }

    composable(ScreenRoute.Discover.route) {
        HomeScreen()
    }

    /* navigation(startDestination = MainNav.MAIN_HOME_SCREEN, route = homeRoute) {
         composable(ScreenRoute.Home.route) {
             HomeScreen(navController)
         }

         composable(ScreenRoute.Discover.route) {
             HomeScreen(navController)
         }
     }*/
}

object MainNav {
    const val MAIN_HOME_SCREEN = "home_screen"
}
