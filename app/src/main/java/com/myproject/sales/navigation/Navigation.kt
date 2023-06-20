package com.myproject.sales.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.myproject.sales.navigation.graph.IntroNav
import com.myproject.sales.navigation.graph.intoGraph
import com.myproject.sales.navigation.graph.mainGraph
import com.myproject.sales.ui.theme.composables.BottomBar
import com.myproject.sales.ui.theme.composables.TopBar

@Composable
fun MyAppNavHost(
    navController: NavHostController = rememberNavController(),
) {
    val bottomBarState = rememberSaveable { (mutableStateOf(false)) }
    val topBarVisibility = rememberSaveable { (mutableStateOf(false)) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    when (navBackStackEntry?.destination?.route) {
        ScreenRoute.Splash.route -> {
            topBarVisibility.value = false
            bottomBarState.value = false
        }

        ScreenRoute.Home.route, ScreenRoute.Menu.route, ScreenRoute.Discover.route -> {
            topBarVisibility.value = false
            bottomBarState.value = true
        }

        else -> {
            topBarVisibility.value = true
            bottomBarState.value = true
        }
    }
    Scaffold(
        topBar = {
            TopBar(
                navController = navController,
                topBarVisibility = topBarVisibility,
            )
        },
        bottomBar = { BottomBar(navController = navController, bottomBarState) },
        content = {
            NavHost(
                navController = navController,
                startDestination = IntroNav.INTRO_ROUTE,
                modifier = Modifier.padding(it),
            ) {
                intoGraph(navController)
                mainGraph(navController)
            }
        },
    )
}
