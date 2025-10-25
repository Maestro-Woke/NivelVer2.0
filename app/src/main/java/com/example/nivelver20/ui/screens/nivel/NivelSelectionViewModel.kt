package com.example.nivelver20.ui.screens.nivel

import androidx.lifecycle.ViewModel
import com.example.nivelver20.data.model.NivelData
import com.example.nivelver20.data.model.NivelItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// ViewModel для экрана выбора уровня
class NivelSelectionViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(NivelSelectionUiState())
    val uiState: StateFlow<NivelSelectionUiState> = _uiState.asStateFlow()

    init {
        loadNiveles()
    }

    private fun loadNiveles() {
        _uiState.value = _uiState.value.copy(
            niveles = NivelData.getAllNiveles()
        )
    }

    fun onNivelSelected(nivelId: String) {
        _uiState.value = _uiState.value.copy(
            selectedNivelId = nivelId
        )
    }
}

// UI State для экрана выбора уровня
data class NivelSelectionUiState(
    val niveles: List<NivelItem> = emptyList(),
    val selectedNivelId: String? = null,
    val title: String = "¿QUÉ\nNIVEL?",
    val bottomText: String = "PRUEBA\nMÁS\nALTO!",
    val testButton: String = "TEST",
    val perfilButton: String = "PERFIL"
)