package com.myproject.sales.navigation

sealed class ScreenRoute(val route: String) {
    object Home : ScreenRoute("main")
    object Discover : ScreenRoute("discover")
    object Splash : ScreenRoute("splash")
    object Menu : ScreenRoute("setting")
    object Profile : ScreenRoute("profile")
}
