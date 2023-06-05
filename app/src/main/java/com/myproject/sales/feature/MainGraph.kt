package com.myproject.sales.feature

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.myproject.sales.screens.HomeScreen

fun NavGraphBuilder.mainGraph(navController: NavController) {
    navigation(startDestination = MainNav.MAIN_HOME_SCREEN, route = MainNav.MAIN_ROUTE) {
        composable(MainNav.MAIN_HOME_SCREEN) {
            HomeScreen(navController)
        }
    }
}

object MainNav {
    const val MAIN_ROUTE = "main"
    const val MAIN_HOME_SCREEN = "home_screen"
}
