package com.example.nivelver20.ui.screens.perfil

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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
import com.example.nivelver20.R
import com.example.nivelver20.ui.theme.rememberAdaptiveDimensions

@Composable
fun PerfilScreen(
    onNavigateToNivel: () -> Unit = {},
    onNavigateToFlujo: () -> Unit = {},
    onNavigateToVocabulario: () -> Unit = {},
    onNavigateToGrammatica: () -> Unit = {},
    onNavigateToAudio: () -> Unit = {},
    onNavigateToLectura: () -> Unit = {},
    onNavigateToTest: () -> Unit = {},
    onNavigateToPerfil: () -> Unit = {},
    viewModel: PerfilViewModel = viewModel()
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
        Image(
            painter = painterResource(id = R.drawable.espanol_logo),
            contentDescription = "Background",
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 40.dp),
            contentScale = ContentScale.Fit,
            alpha = 0.1f
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .padding(horizontal = dimensions.horizontalPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            // Заголовок
            Text(
                text = uiState.title,
                fontSize = dimensions.loginTitleFontSize.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFa3b944),
                textAlign = TextAlign.Center
            )

            // NOMBRE + NIVEL
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(dimensions.loginSpaceBetweenInputs)
            ) {
                Text(
                    text = uiState.nameLabel,
                    fontSize = dimensions.loginLabelFontSize.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFa3b944),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = uiState.nivelLabel,
                    fontSize = dimensions.loginTitleFontSize.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }

            // Кнопки категорий
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(dimensions.spaceBetweenButtons)
            ) {
                // NIVEL
                PerfilButton(
                    text = uiState.nivelButton,
                    onClick = onNavigateToNivel,
                    gradient = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFFF6EC7),
                            Color(0xFFFFE97D)
                        )
                    ),
                    dimensions = dimensions
                )

                // FLUJO
                PerfilButton(
                    text = uiState.flujoButton,
                    onClick = onNavigateToFlujo,
                    gradient = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFFFE97D),
                            Color(0xFFFFB347)
                        )
                    ),
                    dimensions = dimensions
                )

                // VOCABULARIO
                PerfilButton(
                    text = uiState.vocabularioButton,
                    onClick = onNavigateToVocabulario,
                    gradient = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFA0D47B),
                            Color(0xFFE0CA71)
                        )
                    ),
                    dimensions = dimensions
                )

                // GRAMMATICA
                PerfilButton(
                    text = uiState.grammaticaButton,
                    onClick = onNavigateToGrammatica,
                    gradient = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF0097B2),
                            Color(0xFF7ED957)
                        )
                    ),
                    dimensions = dimensions
                )

                // AUDIO
                PerfilButton(
                    text = uiState.audioButton,
                    onClick = onNavigateToAudio,
                    gradient = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF5DE0E6),
                            Color(0xFF1C74CF)
                        )
                    ),
                    dimensions = dimensions
                )

                // LECTURA
                PerfilButton(
                    text = uiState.lecturaButton,
                    onClick = onNavigateToLectura,
                    gradient = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFA985F0),
                            Color(0xFF85EDFF)
                        )
                    ),
                    dimensions = dimensions
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

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
private fun PerfilButton(
    text: String,
    gradient: Brush,
    onClick: () -> Unit,
    dimensions: com.example.nivelver20.ui.theme.AdaptiveDimensions
) {
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