package com.example.nivelver20.ui.screens.vocabulario

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class WordCard(
    val spanish: String,
    val russian: String,
    val isRevealed: Boolean = false
)

data class VocabularioUiState(
    val nivelLabel: String = "NIVEL",
    val nivel: String = "A1",
    val userName: String = "NOMBRE",
    val title: String = "VOCABULARIO",
    val wordCards: List<WordCard> = listOf(
        WordCard("palabra", "слово"),
        WordCard("casa", "дом"),
        WordCard("agua", "вода"),
        WordCard("tiempo", "время"),
        WordCard("persona", "человек"),
        WordCard("día", "день"),
        WordCard("mano", "рука"),
        WordCard("hombre", "мужчина")
    ),
    val correctCount: Int = 25,
    val incorrectCount: Int = 25,
    val testButton: String = "TEST",
    val perfilButton: String = "PERFIL"
)

class VocabularioViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(VocabularioUiState())
    val uiState: StateFlow<VocabularioUiState> = _uiState.asStateFlow()

    fun toggleCard(index: Int) {
        _uiState.update { currentState ->
            val updatedCards = currentState.wordCards.toMutableList()
            updatedCards[index] = updatedCards[index].copy(
                isRevealed = !updatedCards[index].isRevealed
            )
            currentState.copy(wordCards = updatedCards)
        }
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