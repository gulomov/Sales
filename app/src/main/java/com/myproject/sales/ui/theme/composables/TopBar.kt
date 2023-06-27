package com.myproject.sales.ui.theme.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.myproject.sales.R

@Composable
fun TopBar(
    navController: NavController,
    topBarVisibility: MutableState<Boolean>,
) {
    AnimatedVisibility(
        visible = topBarVisibility.value,
        content = {
            TopAppBar(
                title = { Text(text = "") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_back),
                            contentDescription = "",
                        )
                    }
                },
            )
        },
    )
}
