package com.example.nivelver20.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nivelver20.ui.screens.main.MainScreen
import com.example.nivelver20.ui.screens.nivel.NivelSelectionScreen

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
    }
}