@file:OptIn(ExperimentalCoilApi::class)

package com.example.compmoviedb.presentation.screens.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.compmoviedb.domain.models.moviespopular.MoviePopularDetailsD
import com.example.compmoviedb.presentation.navigation.NavRoute
import com.example.compmoviedb.presentation.utils.Constants
import java.util.*

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

@Composable
fun MovieItem(navController: NavController, item: MoviePopularDetailsD) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(6.dp)
            .clickable {
                       navController.navigate(NavRoute.DetailsMovie.route + "/${item.id}")
            },
        shape = CutCornerShape(20.dp),
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(0.dp, 500.dp)
                .padding(vertical = 8.dp, horizontal = 4.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = item.title.uppercase(Locale.getDefault()),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.padding(top = 10.dp))

            Image(
                modifier = Modifier
                    .size(300.dp)
                    .clip(CutCornerShape(15.dp)),
                painter = rememberImagePainter(
                    Constants.Keys.MOVIEDB_BASE_IMAGE_URL + item.poster_path
                ),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )

            Spacer(modifier = Modifier.padding(top = 10.dp))

            Row(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.Start
            ) {
                Text(
                        text = Constants.Keys.RELEASED,
                        fontWeight = FontWeight.Bold,
                )

                Text(text = item.release_date)
            }

            Row(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.Start
            ) {
                Text(
                        text = Constants.Keys.VOTE_AVERAGE,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start
                )

                Text(text = item.vote_average.toString())
            }
        }
    }
}