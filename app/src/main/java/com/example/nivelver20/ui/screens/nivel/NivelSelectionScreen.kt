package com.example.nivelver20.ui.screens.nivel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.example.nivelver20.data.model.NivelItem
import com.example.nivelver20.ui.theme.rememberAdaptiveDimensions

@Composable
fun NivelSelectionScreen(
    onNivelSelected: (String) -> Unit = {},
    onNavigateToTest: () -> Unit = {},
    onNavigateToPerfil: () -> Unit = {},
    viewModel: NivelSelectionViewModel = viewModel()
) {
    val dimensions = rememberAdaptiveDimensions()
    val uiState by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.radialGradient(
                    colors = listOf(
                        Color(0xFF0e5f63),
                        Color(0xFF02214a)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .padding(horizontal = dimensions.horizontalPadding),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            // Первая строка: A1 слева, текст справа
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                NivelItemRow(
                    nivel = uiState.niveles[0],
                    onClick = {
                        viewModel.onNivelSelected(uiState.niveles[0].id)
                        onNivelSelected(uiState.niveles[0].id)
                    },
                    dimensions = dimensions
                )

                Text(
                    text = uiState.title,
                    fontSize = dimensions.nivelTitleFontSize.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFa3b944),
                    textAlign = TextAlign.End,
                    lineHeight = (dimensions.nivelTitleFontSize * 1.1f).sp
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Вторая строка: пусто слева, A2 справа
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                NivelItemRow(
                    nivel = uiState.niveles[1],
                    onClick = {
                        viewModel.onNivelSelected(uiState.niveles[1].id)
                        onNivelSelected(uiState.niveles[1].id)
                    },
                    dimensions = dimensions
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Третья строка: B1 слева, пусто справа
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                NivelItemRow(
                    nivel = uiState.niveles[2],
                    onClick = {
                        viewModel.onNivelSelected(uiState.niveles[2].id)
                        onNivelSelected(uiState.niveles[2].id)
                    },
                    dimensions = dimensions
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Четвертая строка: текст слева, B2 справа
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = uiState.bottomText,
                    fontSize = dimensions.nivelSideTextFontSize.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFa3b944),
                    textAlign = TextAlign.Start,
                    lineHeight = (dimensions.nivelSideTextFontSize * 1.1f).sp
                )

                NivelItemRow(
                    nivel = uiState.niveles[3],
                    onClick = {
                        viewModel.onNivelSelected(uiState.niveles[3].id)
                        onNivelSelected(uiState.niveles[3].id)
                    },
                    dimensions = dimensions
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Нижняя часть: TEST и PERFIL
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
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
private fun NivelItemRow(
    nivel: NivelItem,
    onClick: () -> Unit,
    dimensions: com.example.nivelver20.ui.theme.AdaptiveDimensions
) {
    Box(
        modifier = Modifier
            .width(dimensions.nivelCircleWidth)
            .height(dimensions.nivelCircleHeight)
            .background(
                color = nivel.backgroundColor,
                shape = RoundedCornerShape(50)
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        if (nivel.imageRes != 0) {
            Image(
                painter = painterResource(id = nivel.imageRes),
                contentDescription = nivel.title,
                modifier = Modifier.fillMaxSize(0.75f),
                contentScale = ContentScale.Fit
            )
        }
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