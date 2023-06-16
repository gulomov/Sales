package com.myproject.sales.ui.theme.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myproject.sales.R
import com.myproject.sales.data.MenuList

@Composable
fun MenuItem(menuList: MenuList) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable(
            onClick = {}
        ),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = menuList.title.orEmpty(), fontSize = 14.sp)
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_right),
                contentDescription = ""
            )
        }
    }
}