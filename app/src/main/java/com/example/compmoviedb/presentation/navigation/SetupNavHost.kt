package com.example.compmoviedb.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compmoviedb.presentation.screens.DetailsScreen
import com.example.compmoviedb.presentation.screens.MainScreen
import com.example.compmoviedb.presentation.screens.SplashScreen
import com.example.compmoviedb.presentation.utils.Constants

sealed class Screens(val route: String) {
    object Splash : Screens(route = Constants.Screens.SPLASH_SCREEN)
    object Main : Screens(route = Constants.Screens.MAIN_SCREEN)
    object Details : Screens(route = Constants.Screens.DETAILS_SCREEN)
}

@Composable
fun SetupNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screens.Main.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screens.Details.route + "/{movieId}") { backStackEntry ->
            DetailsScreen(
                navController = navController,
                movieId = backStackEntry.arguments?.getInt("movieId") ?: 0
            )
        }
    }
}