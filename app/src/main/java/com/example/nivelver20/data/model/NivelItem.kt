package com.example.nivelver20.data.model

import androidx.compose.ui.graphics.Color

// Data class для элемента уровня
data class NivelItem(
    val id: String,
    val title: String,
    val imageRes: Int,
    val backgroundColor: Color,
    val isLocked: Boolean = false
)

// Список всех уровней

object NivelData {
    fun getAllNiveles(): List<NivelItem> = listOf(
        NivelItem(
            id = "A1",
            title = "A1",
            imageRes = 0,
            backgroundColor = Color(0xFF7FD4A8)
        ),
        NivelItem(
            id = "A2",
            title = "A2",
            imageRes = 0,
            backgroundColor = Color(0xFFE8D99B)
        ),
        NivelItem(
            id = "B1",
            title = "B1",
            imageRes = 0,
            backgroundColor = Color(0xFF8BD9E8)
        ),
        NivelItem(
            id = "B2",
            title = "B2",
            imageRes = 0,
            backgroundColor = Color(0xFFA8A8E8)
        )
    )
}