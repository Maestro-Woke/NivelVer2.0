package com.example.nivelver20.ui.screens.audio


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class AudioUiState(
    val nivelLabel: String = "NIVEL",
    val nivel: String = "A1",
    val userName: String = "NOMBRE",
    val title: String = "AUDIO",
    val questionLabel: String = "Вопрос",
    val question: String = "¿Qué escuchaste en el audio?",
    val answers: List<String> = listOf(
        "Primera respuesta posible",
        "Segunda respuesta posible",
        "Tercera respuesta posible"
    ),
    val selectedAnswer: Int? = null,
    val isPlaying: Boolean = false,
    val correctCount: Int = 25,
    val incorrectCount: Int = 25,
    val testButton: String = "TEST",
    val perfilButton: String = "PERFIL"
)

class AudioViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AudioUiState())
    val uiState: StateFlow<AudioUiState> = _uiState.asStateFlow()

    fun selectAnswer(index: Int) {
        _uiState.update { it.copy(selectedAnswer = index) }
    }

    fun togglePlayPause() {
        _uiState.update { it.copy(isPlaying = !it.isPlaying) }
        // Здесь будет логика воспроизведения аудио
    }

    fun incrementCorrect() {
        _uiState.update { it.copy(correctCount = it.correctCount + 1) }
    }

    fun incrementIncorrect() {
        _uiState.update { it.copy(incorrectCount = it.incorrectCount + 1) }
    }

    fun setUserName(name: String) {
        _uiState.update { it.copy(userName = name) }
    }

    fun setNivel(nivel: String) {
        _uiState.update { it.copy(nivel = nivel) }
    }
}