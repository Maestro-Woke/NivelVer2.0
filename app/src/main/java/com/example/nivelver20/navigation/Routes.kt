package com.example.nivelver20.navigation

sealed class Routes(val route: String) {
    object Main : Routes("main")
    object Vocabulario : Routes("vocabulario")
}