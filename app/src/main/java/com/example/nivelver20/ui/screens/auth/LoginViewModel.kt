package com.example.nivelver20.ui.screens.auth

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// ViewModel для экрана авторизации
class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onEmailChange(nameUn: String) {
        _uiState.value = _uiState.value.copy(nameUn = nameUn)
    }

    fun onPasswordChange(password: String) {
        _uiState.value = _uiState.value.copy(password = password)
    }

    fun onLogin() {
        // Логика входа - реализуем позже
    }
}

// UI State для экрана авторизации
data class LoginUiState(
    val nameUn: String = "",
    val password: String = "",
    val title: String = "INICIAR SESIÓN",
    val nameLabel: String = "INTRODUCE TU NOMBRE ÚNICO",
    val passwordLabel: String = "CONTRASEÑA",
    val loginButton: String = "ENTRAR",
    val registerButton: String = "REGISTRO",
    val testButton: String = "TEST",
    val perfilButton: String = "PERFIL"
)