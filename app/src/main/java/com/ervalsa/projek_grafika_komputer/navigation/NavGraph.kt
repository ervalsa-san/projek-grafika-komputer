package com.ervalsa.projek_grafika_komputer.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ervalsa.projek_grafika_komputer.ui.feature.concave_mirror.ConcaveMirrorScreen
import com.ervalsa.projek_grafika_komputer.ui.feature.home.HomeScreen
import com.ervalsa.projek_grafika_komputer.ui.feature.splash.AnimatedSplashScreen

@ExperimentalMaterialApi
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            AnimatedSplashScreen(navController)
        }

        composable(route = Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(route = Screen.Concave.route) {
            ConcaveMirrorScreen()
        }
    }
}