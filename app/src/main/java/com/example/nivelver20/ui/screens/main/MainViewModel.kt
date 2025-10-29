package com.example.nivelver20.ui.screens.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

//  ViewModel для главного экрана
class MainViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

}

// UI State для главного экрана
data class MainUiState(
    val nivel: String = "NIVEL",
    val flujo: String = "FLUJO",
    val vocabulario: String = "VOCABULARIO",
    val grammatica: String = "GRAMMATICA",
    val audio: String = "AUDIO",
    val lectura: String = "LECTURA",
    val testButton: String = "TEST",
    val perfilButton: String = "PERFIL"
)