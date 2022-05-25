package com.example.compmoviedb.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compmoviedb.presentation.screens.detailsmovie.DetailsScreen
import com.example.compmoviedb.presentation.screens.main.MainScreen
import com.example.compmoviedb.presentation.screens.splash.SplashScreen

@Composable
fun SetupNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoute.Splash.route
    ) {
        composable(route = NavRoute.Splash.route) {
            SplashScreen(
                navController = navController
            )
        }
        composable(route = NavRoute.Main.route) {
            MainScreen(
                navController = navController
            )
        }
        composable(route = NavRoute.DetailsMovie.route + "/{movieId}") { backStackEntry ->
            DetailsScreen(
                navController = navController,
                movieId = backStackEntry.arguments?.getInt("movieId") ?: 0
            )
        }
    }
}