package com.example.nivelver20.navigation

// Sealed class для навигации между экранами
sealed class Routes(val route: String) {
    object Main : Routes("main")
    object Login : Routes("login")
    object NivelSelection : Routes("nivel_selection")
    object Vocabulario : Routes("vocabulario")
}