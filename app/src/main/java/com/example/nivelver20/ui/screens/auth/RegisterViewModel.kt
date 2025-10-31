
package com.example.nivelver20.ui.screens.auth

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class RegisterUiState(
    val title: String = "REGISTRO",
    val nameLabel: String = "Nombre de usuario",
    val passwordLabel: String = "Contraseña",
    val registerButton: String = "GUARDAR",
    val backButton: String = "ENTRADA",
    val testButton: String = "TEST",
    val perfilButton: String = "PERFIL",
    val nameUn: String = "",
    val password: String = ""
)

class RegisterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()

    fun onNameChange(newName: String) {
        _uiState.update { it.copy(nameUn = newName) }
    }

    fun onPasswordChange(newPassword: String) {
        _uiState.update { it.copy(password = newPassword) }
    }
}