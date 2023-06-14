package com.myproject.sales.feature

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
import com.myproject.sales.feature.graph.intoGraph
import com.myproject.sales.feature.graph.mainGraph
import com.myproject.sales.navigation.ScreenRoute
import com.myproject.sales.ui.theme.composables.BottomBar

@Composable
fun MyAppNavHost(
    navController: NavHostController = rememberNavController(),
) {
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    when (navBackStackEntry?.destination?.route) {
        ScreenRoute.Splash.route -> {
            bottomBarState.value = false
        }

        ScreenRoute.Home.route -> {
            bottomBarState.value = true
        }

        ScreenRoute.Discover.route -> {
            bottomBarState.value = true
        }
    }
    Scaffold(
        bottomBar = { BottomBar(navController = navController, bottomBarState) },
        content = {
            NavHost(
                navController = navController,
                startDestination = ScreenRoute.Splash.route,
                modifier = Modifier.padding(it),
            ) {
                intoGraph(navController)
                mainGraph()
            }
        },
    )
}
