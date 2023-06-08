package com.myproject.sales.screens.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.myproject.sales.data.User
import timber.log.Timber

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = hiltViewModel(),
) {
    val mutableUsers by viewModel.user.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.getData()
    }
    TextList(mutableUsers)
}

@Composable
fun TextList(
    user: User,
    modifier: Modifier = Modifier,
) {
    Timber.d("Are we here")
    Text(text = user.userName.toString())
}
