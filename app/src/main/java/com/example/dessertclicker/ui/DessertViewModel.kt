package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/** Mantiene las ventas mientras se recrea la actividad, por ejemplo al rotar. */
class DessertViewModel : ViewModel() {
    private val desserts = Datasource.dessertList
    private val _uiState = MutableStateFlow(DessertUiState(
        currentDessertPrice = desserts.first().price,
        currentDessertImageId = desserts.first().imageId
    ))
    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()

    fun onDessertClicked() {
        _uiState.update { current ->
            val sold = current.dessertsSold + 1
            val nextDessert = desserts.last { sold >= it.startProductionAmount }
            current.copy(
                dessertsSold = sold,
                // La venta se cobra al precio del postre que se acaba de tocar.
                revenue = current.revenue + current.currentDessertPrice,
                currentDessertPrice = nextDessert.price,
                currentDessertImageId = nextDessert.imageId
            )
        }
    }
}
