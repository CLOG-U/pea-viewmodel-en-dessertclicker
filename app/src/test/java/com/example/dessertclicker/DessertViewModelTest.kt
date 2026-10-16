package com.example.dessertclicker

import com.example.dessertclicker.ui.DessertViewModel
import org.junit.Assert.assertEquals
import org.junit.Test

class DessertViewModelTest {
    @Test
    fun iniciaSinVentasConUnCupcake() {
        val state = DessertViewModel().uiState.value
        assertEquals(0, state.dessertsSold)
        assertEquals(0, state.revenue)
        assertEquals(5, state.currentDessertPrice)
        assertEquals(R.drawable.cupcake, state.currentDessertImageId)
    }

    @Test
    fun laPrimeraVentaSumaElPrecioActual() {
        val model = DessertViewModel()
        model.onDessertClicked()
        assertEquals(1, model.uiState.value.dessertsSold)
        assertEquals(5, model.uiState.value.revenue)
    }

    @Test
    fun laQuintaVentaCambiaElPostreSinCobrarAntesElNuevoPrecio() {
        val model = DessertViewModel()
        repeat(5) { model.onDessertClicked() }
        assertEquals(25, model.uiState.value.revenue)
        assertEquals(R.drawable.donut, model.uiState.value.currentDessertImageId)
        assertEquals(10, model.uiState.value.currentDessertPrice)
        model.onDessertClicked()
        assertEquals(6, model.uiState.value.dessertsSold)
        assertEquals(35, model.uiState.value.revenue)
    }

    @Test
    fun alLlegarAVeinteVentasComienzaElEclair() {
        val model = DessertViewModel()
        repeat(20) { model.onDessertClicked() }
        assertEquals(175, model.uiState.value.revenue)
        assertEquals(R.drawable.eclair, model.uiState.value.currentDessertImageId)
        assertEquals(15, model.uiState.value.currentDessertPrice)
        model.onDessertClicked()
        assertEquals(190, model.uiState.value.revenue)
    }
}
