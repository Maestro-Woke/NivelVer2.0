package com.example.nivelver20.ui.screens.vocabulario

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nivelver20.ui.theme.rememberAdaptiveDimensions

@Composable
fun VocabularioScreen(
    nivel: String = "A1",
    onNavigateToTest: () -> Unit = {},
    onNavigateToPerfil: () -> Unit = {},
    viewModel: VocabularioViewModel = viewModel()
) {
    val dimensions = rememberAdaptiveDimensions()
    val uiState by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF02214a))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .padding(horizontal = dimensions.horizontalPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(dimensions.verticalPadding))

            // Верхняя строка: NIVEL и NOMBRE
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = uiState.nivelLabel,
                    fontSize = dimensions.loginLabelFontSize.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFa3b944)
                )

                Text(
                    text = uiState.userName,
                    fontSize = dimensions.loginLabelFontSize.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFa3b944)
                )
            }

            Spacer(modifier = Modifier.height(dimensions.verticalPadding))


            // Карточка с заголовком и словами
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFF88D498),
                                Color(0xFFB4B487)
                            )
                        ),
                        shape = RoundedCornerShape(dimensions.buttonCornerRadius)
                    )
                    .padding(dimensions.vocabularioPadding)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Заголовок VOCABULARIO
                    Text(
                        text = uiState.title,
                        fontSize = dimensions.vocabularioTitleFontSize.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // БЛОК ИСПАНСКИХ СЛОВ (4 карточки в 2 рядах)
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        verticalArrangement = Arrangement.spacedBy(dimensions.vocabularioCardSpacing)
                    ) {
                        // Первый ряд испанских слов
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            horizontalArrangement = Arrangement.spacedBy(dimensions.vocabularioCardSpacing)
                        ) {
                            WordCardItem(
                                card = uiState.wordCards[0],
                                onClick = { viewModel.toggleCard(0) },
                                dimensions = dimensions,
                                modifier = Modifier.weight(1f)
                            )
                            WordCardItem(
                                card = uiState.wordCards[1],
                                onClick = { viewModel.toggleCard(1) },
                                dimensions = dimensions,
                                modifier = Modifier.weight(1f)
                            )
                        }

                        // Второй ряд испанских слов
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            horizontalArrangement = Arrangement.spacedBy(dimensions.vocabularioCardSpacing)
                        ) {
                            WordCardItem(
                                card = uiState.wordCards[2],
                                onClick = { viewModel.toggleCard(2) },
                                dimensions = dimensions,
                                modifier = Modifier.weight(1f)
                            )
                            WordCardItem(
                                card = uiState.wordCards[3],
                                onClick = { viewModel.toggleCard(3) },
                                dimensions = dimensions,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(dimensions.vocabularioCardSpacing))

                    // БЛОК РУССКИХ СЛОВ (4 карточки в 2 рядах)
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        verticalArrangement = Arrangement.spacedBy(dimensions.vocabularioCardSpacing)
                    ) {
                        // Первый ряд русских слов
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            horizontalArrangement = Arrangement.spacedBy(dimensions.vocabularioCardSpacing)
                        ) {
                            WordCardItem(
                                card = uiState.wordCards[4],
                                onClick = { viewModel.toggleCard(4) },
                                dimensions = dimensions,
                                modifier = Modifier.weight(1f)
                            )
                            WordCardItem(
                                card = uiState.wordCards[5],
                                onClick = { viewModel.toggleCard(5) },
                                dimensions = dimensions,
                                modifier = Modifier.weight(1f)
                            )
                        }

                        // Второй ряд русских слов
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            horizontalArrangement = Arrangement.spacedBy(dimensions.vocabularioCardSpacing)
                        ) {
                            WordCardItem(
                                card = uiState.wordCards[6],
                                onClick = { viewModel.toggleCard(6) },
                                dimensions = dimensions,
                                modifier = Modifier.weight(1f)
                            )
                            WordCardItem(
                                card = uiState.wordCards[7],
                                onClick = { viewModel.toggleCard(7) },
                                dimensions = dimensions,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Счетчики внизу
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = uiState.incorrectCount.toString(),
                            fontSize = dimensions.vocabularioCounterFontSize.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFF4444)
                        )

                        Text(
                            text = uiState.correctCount.toString(),
                            fontSize = dimensions.vocabularioCounterFontSize.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF00FF00)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(dimensions.verticalPadding))

            // Нижняя часть: TEST и PERFIL
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = dimensions.verticalPadding),
                horizontalArrangement = Arrangement.spacedBy(dimensions.spaceBetweenButtons)
            ) {
                BottomButton(
                    text = uiState.testButton,
                    onClick = onNavigateToTest,
                    dimensions = dimensions,
                    modifier = Modifier.weight(1f)
                )

                BottomButton(
                    text = uiState.perfilButton,
                    onClick = onNavigateToPerfil,
                    dimensions = dimensions,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun WordCardItem(
    card: WordCard,
    onClick: () -> Unit,
    dimensions: com.example.nivelver20.ui.theme.AdaptiveDimensions,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .background(
                color = Color(0xFFF5F5DC),
                shape = RoundedCornerShape(dimensions.vocabularioCardCornerRadius)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (card.isRevealed) card.russian else card.spanish,
            fontSize = dimensions.vocabularioWordFontSize.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF003D5B),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Composable
private fun BottomButton(
    text: String,
    onClick: () -> Unit,
    dimensions: com.example.nivelver20.ui.theme.AdaptiveDimensions,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(dimensions.bottomButtonHeight)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFA985F0),
                        Color(0xFF85EDFF)
                    )
                ),
                shape = RoundedCornerShape(dimensions.buttonCornerRadius)
            )
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxSize()
                .padding(2.dp),
            shape = RoundedCornerShape(dimensions.buttonCornerRadius),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF003D5B)
            ),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = text,
                fontSize = dimensions.bottomButtonFontSize.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFa3b944),
                textAlign = TextAlign.Center
            )
        }
    }
}