package com.example.nivelver20.ui.screens.lectura

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class LecturaUiState(
    val nivelLabel: String = "NIVEL",
    val nivel: String = "A1",
    val userName: String = "NOMBRE",
    val title: String = "LECTURA",
    val text: String = "Здесь будет текст для чтения на испанском языке. Студент должен прочитать этот текст и ответить на вопросы ниже.¿Qué es lo que hace verdaderamente valiosa a una persona?\n" +
            "• ¿Por qué crees que algunas personas les dan más importancia a aspectos como el color de la piel, el dinero o la apariencia física que a los valores y a\n" +
            "la forma de ser?¿Qué es lo que hace verdaderamente valiosa a una persona?\n" +
            "• ¿Por qué crees que algunas personas les dan más importancia a aspectos como el color de la piel, el dinero o la apariencia física que a los valores y a\n" +
            "la forma de ser?¿Qué es lo que hace verdaderamente valiosa a una persona?\n" +
            "• ¿Por qué crees que algunas personas les dan más importancia a aspectos como el color de la piel, el dinero o la apariencia física que a los valores y a\n" +
            "la forma de ser?¿Qué es lo que hace verdaderamente valiosa a una persona?\n" +
            "• ¿Por qué crees que algunas personas les dan más importancia a aspectos como el color de la piel, el dinero o la apariencia física que a los valores y a\n" +
            "la forma de ser?¿Qué es lo que hace verdaderamente valiosa a una persona?\n" +
            "• ¿Por qué crees que algunas personas les dan más importancia a aspectos como el color de la piel, el dinero o la apariencia física que a los valores y a\n" +
            "la forma de ser?¿Qué es lo que hace verdaderamente valiosa a una persona?\n" +
            "• ¿Por qué crees que algunas personas les dan más importancia a aspectos como el color de la piel, el dinero o la apariencia física que a los valores y a\n" +
            "la forma de ser?¿Qué es lo que hace verdaderamente valiosa a una persona?\n" +
            "• ¿Por qué crees que algunas personas les dan más importancia a aspectos como el color de la piel, el dinero o la apariencia física que a los valores y a\n" +
            "la forma de ser?¿Qué es lo que hace verdaderamente valiosa a una persona?\n" +
            "• ¿Por qué crees que algunas personas les dan más importancia a aspectos como el color de la piel, el dinero o la apariencia física que a los valores y a\n" +
            "la forma de ser?¿Qué es lo que hace verdaderamente valiosa a una persona?\n" +
            "• ¿Por qué crees que algunas personas les dan más importancia a aspectos como el color de la piel, el dinero o la apariencia física que a los valores y a\n" +
            "la forma de ser?¿Qué es lo que hace verdaderamente valiosa a una persona?\n" +
            "• ¿Por qué crees que algunas personas les dan más importancia a aspectos como el color de la piel, el dinero o la apariencia física que a los valores y a\n" +
            "la forma de ser?¿Qué es lo que hace verdaderamente valiosa a una persona?\n" +
            "• ¿Por qué crees que algunas personas les dan más importancia a aspectos como el color de la piel, el dinero o la apariencia física que a los valores y a\n" +
            "la forma de ser?¿Qué es lo que hace verdaderamente valiosa a una persona?\n" +
            "• ¿Por qué crees que algunas personas les dan más importancia a aspectos como el color de la piel, el dinero o la apariencia física que a los valores y a\n" +
            "la forma de ser?¿Qué es lo que hace verdaderamente valiosa a una persona?\n" +
            "• ¿Por qué crees que algunas personas les dan más importancia a aspectos como el color de la piel, el dinero o la apariencia física que a los valores y a\n" +
            "la forma de ser?¿Qué es lo que hace verdaderamente valiosa a una persona?\n" +
            "• ¿Por qué crees que algunas personas les dan más importancia a aspectos como el color de la piel, el dinero o la apariencia física que a los valores y a\n" +
            "la forma de ser?",
    val question: String = "¿Cuál es el tema principal del texto?",
    val answers: List<String> = listOf(
        "Primera respuesta posible",
        "Segunda respuesta posible",
        "Tercera respuesta posible"
    ),
    val selectedAnswer: Int? = null,
    val correctCount: Int = 25,
    val incorrectCount: Int = 25,
    val testButton: String = "TEST",
    val perfilButton: String = "PERFIL"
)

class LecturaViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LecturaUiState())
    val uiState: StateFlow<LecturaUiState> = _uiState.asStateFlow()

    fun selectAnswer(index: Int) {
        _uiState.update { it.copy(selectedAnswer = index) }
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