package com.example.compmoviedb.presentation.screens.detailsmovie

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun DetailsMovieScreen(navController: NavController, movieId: String) {

    val mViewModel = hiltViewModel<DetailsMovieViewModel>()

    LaunchedEffect(key1 = Unit, block = {
        mViewModel.getMovieDetailsById(movieId = movieId.toInt())
    })
}