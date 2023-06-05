package com.myproject.sales.feature

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.myproject.sales.screens.SplashScreen

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
