package com.example.compmoviedb.presentation.navigation

import com.example.compmoviedb.presentation.utils.Constants

sealed class NavRoute(val route: String) {
    object Splash : NavRoute(route = Constants.Screens.SPLASH_SCREEN)
    object Main : NavRoute(route = Constants.Screens.MAIN_SCREEN)
    object DetailsMovie : NavRoute(route = Constants.Screens.DETAILS_MOVIE_SCREEN)
}