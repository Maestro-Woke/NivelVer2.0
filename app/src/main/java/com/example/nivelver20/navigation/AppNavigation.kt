package com.example.nivelver20.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nivelver20.ui.screens.main.MainScreen
import com.example.nivelver20.ui.screens.nivel.NivelSelectionScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Главная навигация приложения
@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Main.route
    ) {
        // Главный экран
        composable(Routes.Main.route) {
            MainScreen(
                onNavigateToVocabulario = {
                    navController.navigate(Routes.NivelSelection.route)
                },
                onNavigateToGrammatica = {
                    // Пока пусто
                },
                onNavigateToAudio = {
                    // Пока пусто
                },
                onNavigateToLectura = {
                    // Пока пусто
                },
                onNavigateToTest = {
                    // Пока пусто
                },
                onNavigateToPerfil = {
                    // Пока пусто
                }
            )
        }

        // Экран выбора уровня
        composable(Routes.NivelSelection.route) {
            NivelSelectionScreen(
                onNivelSelected = { nivelId ->
                    // Когда выберут уровень, перейдем на Vocabulario
                    navController.navigate(Routes.Vocabulario.route + "/$nivelId")
                },
                onNavigateToTest = {
                    // Вернуться на главный экран
                    navController.popBackStack(Routes.Main.route, false)
                },
                onNavigateToPerfil = {
                    // Вернуться на главный экран
                    navController.popBackStack(Routes.Main.route, false)
                }
            )
        }

        // Экран Vocabulario (пока заглушка)
        composable(Routes.Vocabulario.route + "/{nivelId}") { backStackEntry ->
            val nivelId = backStackEntry.arguments?.getString("nivelId") ?: "A1"
            // Временная заглушка
            PlaceholderScreen(
                text = "Vocabulario\nNivel: $nivelId",
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

// Временный экран-заглушка
@Composable
private fun PlaceholderScreen(
    text: String,
    onBack: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF02214a)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = text,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Button(
                onClick = onBack,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFa3b944)
                )
            ) {
                Text(
                    text = "НАЗАД",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}