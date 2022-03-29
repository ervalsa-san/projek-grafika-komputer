package com.ervalsa.projek_grafika_komputer.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
    object Concave : Screen("concave_screen")
}