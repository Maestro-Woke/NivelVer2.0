package com.example.nivelver20.ui.screens.perfil

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class PerfilUiState(
    val title: String = "RESULTADOS",
    val nameLabel: String = "NOMBRE",
    val userName: String = "Usuario123",
    val nivelLabel: String = "NIVEL",
    val userNivel: String = "A2",
    val nivelButton: String = "NIVEL",
    val flujoButton: String = "FLUJO",
    val vocabularioButton: String = "VOCABULARIO",
    val grammaticaButton: String = "GRAMMATICA",
    val audioButton: String = "AUDIO",
    val lecturaButton: String = "LECTURA",
    val testButton: String = "TEST",
    val perfilButton: String = "PERFIL"
)

class PerfilViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(PerfilUiState())
    val uiState: StateFlow<PerfilUiState> = _uiState.asStateFlow()

    fun updateUserName(name: String) {
        _uiState.update { it.copy(userName = name) }
    }

    fun updateUserNivel(nivel: String) {
        _uiState.update { it.copy(userNivel = nivel) }
    }
}