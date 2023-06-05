package com.myproject.sales.feature

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.myproject.sales.feature.graph.IntroNav
import com.myproject.sales.feature.graph.intoGraph
import com.myproject.sales.feature.graph.mainGraph

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = IntroNav.INTRO_ROUTE,
    ) {
        intoGraph(navController)
        mainGraph(navController)
    }
}
