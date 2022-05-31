@file:OptIn(ExperimentalCoilApi::class)

package com.example.compmoviedb.presentation.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi

@Composable
fun MainScreen(navController: NavController) {
    val mViewModel = hiltViewModel<MainViewModel>()

    val listMoviesPopular = mViewModel.listMoviesPopular.collectAsState().value

    LaunchedEffect(key1 = Unit, block = {
        mViewModel.getListMoviesPopular()
    })

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(listMoviesPopular) { movie ->
                MovieItem(navController = navController, item = movie)
            }
        }
    }
}