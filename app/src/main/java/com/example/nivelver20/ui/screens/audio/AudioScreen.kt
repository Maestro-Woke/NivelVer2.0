package com.example.nivelver20.ui.screens.audio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nivelver20.R
import com.example.nivelver20.ui.theme.rememberAdaptiveDimensions

@Composable
fun AudioScreen(
    nivel: String = "A1",
    onNavigateToTest: () -> Unit = {},
    onNavigateToPerfil: () -> Unit = {},
    viewModel: AudioViewModel = viewModel()
) {
    val dimensions = rememberAdaptiveDimensions()
    val uiState by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF02214a)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.espanol_logo),
            contentDescription = "Background",
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.7f),
            alpha = 0.15f,
            contentScale = ContentScale.Fit
        )
    }

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

        // Карточка с заголовком, аудио плеером и вопросами
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFA985F0),
                            Color(0xFF85edff)
                        )
                    ),
                    alpha = 0.55f,
                    shape = RoundedCornerShape(dimensions.buttonCornerRadius)
                )
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.height(dimensions.vocabularioPadingH))

                // Заголовок AUDIO
                Text(
                    text = uiState.title,
                    fontSize = dimensions.vocabularioTitleFontSize.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFf2edd0),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(dimensions.vocabularioPadingH))

                // АУДИО ПЛЕЕР
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .background(
                            color = Color(0x40FFFFFF),
                            shape = RoundedCornerShape(dimensions.vocabularioCardCornerRadius)
                        )
                        .padding(dimensions.vocabularioPadding),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        // Иконка звука
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                            contentDescription = "Audio",
                            modifier = Modifier
                                .size(dimensions.audioVolumeUp)
                        )

                        Spacer(modifier = Modifier.height(24.dp))
                    }
                }

                Spacer(modifier = Modifier.height(dimensions.vocabularioCardSpacing))

                // ВОПРОС
                Text(
                    text = uiState.questionLabel,
                    fontSize = dimensions.vocabularioTitleFontSize.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFf2edd0),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(dimensions.vocabularioCardSpacing))

                // ВАРИАНТЫ ОТВЕТОВ
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(dimensions.vocabularioCardSpacing)
                ) {
                    uiState.answers.forEachIndexed { index, answer ->
                        AnswerItem(
                            answer = answer,
                            isSelected = uiState.selectedAnswer == index,
                            onClick = { viewModel.selectAnswer(index) },
                            dimensions = dimensions
                        )
                    }
                }

                Spacer(modifier = Modifier.height(dimensions.vocabularioPadingH))

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

                Spacer(modifier = Modifier.height(dimensions.vocabularioPadingH))
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

@Composable
private fun AnswerItem(
    answer: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    dimensions: com.example.nivelver20.ui.theme.AdaptiveDimensions
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = if (isSelected) Color(0xFFFFD700) else Color(0xFFF5F5DC),
                shape = RoundedCornerShape(dimensions.vocabularioCardCornerRadius)
            )
            .clickable { onClick() }
            .padding(vertical = 12.dp, horizontal = dimensions.vocabularioPadding),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = answer,
            fontSize = dimensions.vocabularioWordFontSize.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = Color(0xFF003D5B),
            textAlign = TextAlign.Center
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