package com.myproject.sales

import android.content.res.Resources
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.myproject.sales.navigation.ScreenRoute
import kotlinx.coroutines.CoroutineScope

@Composable
fun resources(): Resources = LocalContext.current.resources

@Composable
fun rememberAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController(),
    resources: Resources = resources(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
) = remember(
    scaffoldState,
    navController,
    resources,
    coroutineScope,
) {
    State(scaffoldState, navController, resources, coroutineScope)
}

class State(
    val scaffoldState: ScaffoldState,
    val navController: NavHostController,
    private val resources: Resources,
    coroutineScope: CoroutineScope,
) {
    val isSplashScreen: Boolean
        @Composable get() = navController
            .currentBackStackEntryAsState()
            .value?.destination?.route.equals(ScreenRoute.Splash.route)

    /*lateinit var categorySelected: Category
    lateinit var productSelected: Product*/

    /*    private val screensWithArrowBack = ScreenRoute.withArrowBack.map { it.route }*/

    /*val shouldShowArrowBack: Boolean
        @Composable get() = navController
            .currentBackStackEntryAsState()
            .value?.destination?.route in screensWithArrowBack*/
}
