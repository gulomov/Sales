package com.myproject.sales.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.myproject.sales.R

// Set of Material typography styles to start with
val SalesFont = FontFamily(
    Font(R.font.opensans_regular),
    Font(R.font.opensans_semibold),
)
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = SalesFont,
        fontWeight = FontWeight.Black,
        fontSize = 16.sp,
    ),
    h1 = TextStyle(
        fontFamily = SalesFont,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
    ),
    body2 = TextStyle(
        fontFamily = SalesFont,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
    ),
    h2 = TextStyle(
        fontFamily = SalesFont,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
    ),

    button = TextStyle(
        fontFamily = SalesFont,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
    ),
    caption = TextStyle(
        fontFamily = SalesFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
)
