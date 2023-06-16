package com.myproject.sales.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController

@Composable

fun TopBar(navController: NavController, bottomBarState: MutableState<Boolean>) {

    TopAppBar(
        title = { Text(text = "App") },
        navigationIcon = {
            if (!bottomBarState.value) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                }
            } else {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Filled.Home, contentDescription = "")
                }
            }
        }
    )
}