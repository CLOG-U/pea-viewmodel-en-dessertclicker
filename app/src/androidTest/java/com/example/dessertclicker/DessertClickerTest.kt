package com.example.dessertclicker

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class DessertClickerTest {
    @get:Rule
    val compose = createAndroidComposeRule<MainActivity>()

    @Test
    fun lasVentasSeConservanAlRecrearLaActividad() {
        compose.onNodeWithText("0").assertIsDisplayed()
        compose.onNodeWithText("$0").assertIsDisplayed()
        repeat(6) {
            compose.onNodeWithContentDescription("Vender un postre").performClick()
        }
        compose.onNodeWithText("6").assertIsDisplayed()
        compose.onNodeWithText("$35").assertIsDisplayed()
        compose.activityRule.scenario.recreate()
        compose.onNodeWithText("6").assertIsDisplayed()
        compose.onNodeWithText("$35").assertIsDisplayed()
        compose.onNodeWithContentDescription("Vender un postre").performClick()
        compose.onNodeWithText("7").assertIsDisplayed()
        compose.onNodeWithText("$45").assertIsDisplayed()
    }
}
