package com.myproject.sales.ui.theme.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.myproject.sales.data.Likes

@Composable
fun Product(
    product: Likes,
    productSelected: (product: Likes) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(product.productImage)
                .crossfade(true)
                .build(),
            contentDescription = "",
            placeholder = painterResource(id = coil.base.R.drawable.ic_100tb),
        )
    }
}

@Preview
@Composable
fun Product() {
}
