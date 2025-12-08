package com.example.nivelver20.ui.screens.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nivelver20.data.repository.RealmRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class RegisterUiState(
    val title: String = "REGISTRO",
    val nameLabel: String = "Nombre de usuario",
    val passwordLabel: String = "Contraseña",
    val registerButton: String = "GUARDAR",
    val backButton: String = "ENTRADA",
    val testButton: String = "TEST",
    val perfilButton: String = "PERFIL",
    val nameUn: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

class RegisterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()

    private val repository = RealmRepository()

    fun onNameChange(newName: String) {
        _uiState.update { it.copy(nameUn = newName) }
    }

    fun onPasswordChange(newPassword: String) {
        _uiState.update { it.copy(password = newPassword) }
    }

    fun registerUser(onSuccess: () -> Unit) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }

            try {
                val username = _uiState.value.nameUn
                val password = _uiState.value.password

                if (username.isBlank() || password.isBlank()) {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = "Заполните все поля"
                        )
                    }
                    return@launch
                }

                // Проверка существования пользователя
                val existingUser = repository.getUserByUsername(username)
                if (existingUser != null) {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = "Пользователь уже существует"
                        )
                    }
                    return@launch
                }

                // Создание нового пользователя
                repository.createUser(username, password)

                _uiState.update { it.copy(isLoading = false) }
                onSuccess()

            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = "Ошибка: ${e.message}"
                    )
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        repository.close()
    }
}