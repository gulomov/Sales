package com.myproject.sales.screens.menu.aboutapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun AboutAppScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "A", modifier = Modifier.align(Alignment.Center))
    }
}
