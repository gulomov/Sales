package com.myproject.sales

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.myproject.sales.screens.home.HomeScreen
import com.myproject.sales.ui.theme.SalesTheme
import org.junit.Rule
import org.junit.Test

class MyComposeTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myTest() {
        composeTestRule.setContent {
            SalesTheme {
                HomeScreen()
            }
        }

        composeTestRule.onNodeWithText("Continue").performClick()
        composeTestRule.onNodeWithText("Welcome").assertIsDisplayed()
    }
}
