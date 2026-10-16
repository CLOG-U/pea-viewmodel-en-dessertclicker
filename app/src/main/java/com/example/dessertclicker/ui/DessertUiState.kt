package com.example.dessertclicker.ui

import androidx.annotation.DrawableRes
import com.example.dessertclicker.R

/** Valores que necesita la pantalla para representar una venta. */
data class DessertUiState(
    val dessertsSold: Int = 0,
    val revenue: Int = 0,
    val currentDessertPrice: Int = 5,
    @DrawableRes val currentDessertImageId: Int = R.drawable.cupcake
)
