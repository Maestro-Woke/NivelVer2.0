package com.example.nivelver20.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nivelver20.ui.theme.rememberAdaptiveDimensions
import com.example.nivelver20.R


@Composable
fun MainScreen(
    onNavigateToVocabulario: () -> Unit = {},
    onNavigateToGrammatica: () -> Unit = {},
    onNavigateToAudio: () -> Unit = {},
    onNavigateToLectura: () -> Unit = {},
    onNavigateToTest: () -> Unit = {},
    onNavigateToPerfil: () -> Unit = {},
    viewModel: MainViewModel = viewModel()
) {
    val dimensions = rememberAdaptiveDimensions()
    val uiState by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF003D5B),
                        Color(0xFF00516D)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = dimensions.horizontalPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            // Верхняя часть: NIVEL и FLUJO (не кликабельные)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensions.verticalPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(dimensions.spaceBetweenButtons)
            ) {
                // NIVEL Button (не кликабельна)
                NonClickableButton(
                    text = uiState.nivel,
                    gradient = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFFF6EC7),
                            Color(0xFFFFE97D)
                        )
                    ),
                    dimensions = dimensions
                )

                // FLUJO Button (не кликабельна)
                NonClickableButton(
                    text = uiState.flujo,
                    gradient = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFFFE97D),
                            Color(0xFFFFB347)
                        )
                    ),
                    dimensions = dimensions
                )
            }

            // Центральная часть: Буква Ñ (ФОТО - изображение)
            Box(
                modifier = Modifier
                    .size(dimensions.letterNSize)
                    .padding(
                        top = dimensions.letterNTopPadding,
                        bottom = dimensions.letterNBottomPadding
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Letter Ñ",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }

            // Средняя часть: Основные кнопки меню
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(dimensions.spaceBetweenButtons)
            ) {
                MainMenuButton(
                    text = "VOCABULARIO",
                    gradient = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFD4E157),
                            Color(0xFFFFEB99)
                        )
                    ),
                    onClick = onNavigateToVocabulario,
                    dimensions = dimensions
                )

                MainMenuButton(
                    text = "GRAMMÁTICA",
                    gradient = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF26C6DA),
                            Color(0xFF80DEEA)
                        )
                    ),
                    onClick = onNavigateToGrammatica,
                    dimensions = dimensions
                )

                MainMenuButton(
                    text = "AUDIO",
                    gradient = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF4DD0E1),
                            Color(0xFF80DEEA)
                        )
                    ),
                    onClick = onNavigateToAudio,
                    dimensions = dimensions
                )

                MainMenuButton(
                    text = "LECTURA",
                    gradient = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF9575CD),
                            Color(0xFF81D4FA)
                        )
                    ),
                    onClick = onNavigateToLectura,
                    dimensions = dimensions
                )
            }

            // Нижняя часть: TEST и PERFIL
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = dimensions.verticalPadding),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                BottomButton(
                    text = "TEST",
                    onClick = onNavigateToTest,
                    dimensions = dimensions
                )

                BottomButton(
                    text = "PERFIL",
                    onClick = onNavigateToPerfil,
                    dimensions = dimensions
                )
            }
        }
    }
}

// Некликабельная кнопка для NIVEL и FLUJO
@Composable
private fun NonClickableButton(
    text: String,
    gradient: Brush,
    dimensions: com.example.nivelver20.ui.theme.AdaptiveDimensions
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensions.buttonHeight)
            .background(
                brush = gradient,
                shape = RoundedCornerShape(dimensions.buttonCornerRadius)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = dimensions.titleFontSize.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2C3E50),
            textAlign = TextAlign.Center
        )
    }
}

// Кнопка основного меню (кликабельная)
@Composable
private fun MainMenuButton(
    text: String,
    gradient: Brush,
    onClick: () -> Unit,
    dimensions: com.example.nivelver20.ui.theme.AdaptiveDimensions) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensions.buttonHeight),
        shape = RoundedCornerShape(dimensions.buttonCornerRadius),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                fontSize = dimensions.buttonFontSize.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2C3E50),
                textAlign = TextAlign.Center
            )
        }
    }
}

// Нижние кнопки TEST и PERFIL
@Composable
private fun BottomButton(
    text: String,
    onClick: () -> Unit,
    dimensions: com.example.nivelver20.ui.theme.AdaptiveDimensions) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(dimensions.bottomButtonWidth)
            .height(dimensions.bottomButtonHeight),
        shape = RoundedCornerShape(dimensions.buttonCornerRadius),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        border = androidx.compose.foundation.BorderStroke(2.dp, Color(0xFF4DD0E1)),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            text = text,
            fontSize = dimensions.bottomButtonFontSize.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFE97D),
            textAlign = TextAlign.Center
        )
    }
}