package com.myproject.sales.screens.dicvory

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.myproject.sales.data.Likes
import com.myproject.sales.screens.home.HomeScreenViewModel
import com.myproject.sales.ui.theme.composables.Product

@Composable
fun DiscoverScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
) {
    val mutableUsers by viewModel.user.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.getData()
    }
    mutableUsers.products?.let { DiscoverList(it) }
}

@Composable
fun DiscoverList(
    user: List<Likes>,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxWidth().padding(16.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(user) { like ->
            Product(product = like, productSelected = {})
        }
    }
}
