package com.myproject.sales.screens.dicvory

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
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
    mutableUsers.products?.let { ProductList(it) }
}

@Composable
fun ProductList(
    user: List<Likes>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(user) { like ->
            Product(product = like, productSelected = {})
        }
    }
}
