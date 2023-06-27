package com.myproject.sales.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.myproject.sales.screens.splash.SplashScreen

fun NavGraphBuilder.intoGraph(navController: NavController) {
    navigation(startDestination = IntroNav.INTRO_SPLASH, route = IntroNav.INTRO_ROUTE) {
        composable(IntroNav.INTRO_SPLASH) {
            SplashScreen(navController = navController)
        }
    }
}

object IntroNav {
    const val INTRO_ROUTE = "intro"
    const val INTRO_SPLASH = "splash"
}
