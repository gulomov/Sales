package com.myproject.sales.screens.menu.aboutapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AboutAppScreen(
    viewModel: AboutAppViewModel = hiltViewModel(),
) {
    val aboutText by viewModel.aboutAppText.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.getData()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = aboutText.title.orEmpty(),
            modifier = Modifier.align(Alignment.Center),
            color = Color.Black,
        )
    }
}
