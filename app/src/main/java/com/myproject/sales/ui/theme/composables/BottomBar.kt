package com.myproject.sales.ui.theme.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.myproject.sales.navigation.NavigationBarSection

@Composable
fun BottomBar(navController: NavController, bottomBarState: MutableState<Boolean>) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val selectedIndex = remember { mutableSetOf(0) }

    AnimatedVisibility(
        visible = bottomBarState.value,
        content = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.background,
                contentColor = contentColorFor(MaterialTheme.colors.background),
                elevation = 10.dp,
            ) {
                NavigationBarSection.sections.forEach { section ->
                    val selected = currentDestination?.hierarchy?.any {
                        it.route == section.route
                    }
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = section.icon,
                                contentDescription = stringResource(id = section.title),
                            )
                        },
                        label = { Text(text = stringResource(id = section.title)) },
                        selected = selected == true,
                        unselectedContentColor = Color.Gray,
                        selectedContentColor = Color.Red,
                        onClick = {
                            navController.navigate(section.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                    )
                }
            }
        },
    )
}
