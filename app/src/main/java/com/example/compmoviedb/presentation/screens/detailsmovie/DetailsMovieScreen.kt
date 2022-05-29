package com.example.compmoviedb.presentation.screens.detailsmovie

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.compmoviedb.presentation.utils.Constants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import java.util.*


@Composable
fun DetailsMovieScreen(navController: NavController, movieId: String) {

    val mViewModel = hiltViewModel<DetailsMovieViewModel>()

    val scrollState = rememberScrollState()
    val movieDetails = mViewModel.movieDetails.collectAsState().value

    val movieVideoYoutubeID = mViewModel.movieVideoYoutubeID.collectAsState().value

    LaunchedEffect(key1 = Unit, block = {
        mViewModel.getMovieDetailsById(movieId = movieId.toInt())
        mViewModel.getListMovieVideo(movieId = movieId.toInt())
    })

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = scrollState),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(300.dp)
                    .clip(CutCornerShape(15.dp)),
                painter = rememberImagePainter(
                    Constants.Keys.MOVIEDB_BASE_IMAGE_URL + movieDetails.poster_path
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.padding(top = 10.dp))

            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = movieDetails.title.uppercase(Locale.getDefault()),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.padding(top = 10.dp))

            Divider(color = MaterialTheme.colors.primary, thickness = 2.dp)

            Spacer(modifier = Modifier.padding(top = 10.dp))

            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                fontSize = 16.sp,
                text = movieDetails.overview,
                textAlign = TextAlign.Justify
            )

            Spacer(modifier = Modifier.padding(top = 10.dp))

            if (movieVideoYoutubeID.isNotEmpty()) {
                YoutubePlayer(youtubeVideoID = movieVideoYoutubeID)
            }

            Spacer(modifier = Modifier.padding(top = 10.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = Constants.Keys.RELEASED,
                    fontWeight = FontWeight.Bold,
                )
                Text(text = movieDetails.release_date)

                Spacer(modifier = Modifier.padding(top = 10.dp))

                Text(
                    text = Constants.Keys.PRODUCTION_COUNTRIES,
                    fontWeight = FontWeight.Bold,
                )
                movieDetails.production_countries.forEach { productionCountry ->
                    Text(text = productionCountry.name.uppercase(Locale.getDefault()))
                }
            }
        }
    }
}

@Composable
fun YoutubePlayer(youtubeVideoID: String) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AndroidView(
            factory = {
                YouTubePlayerView(context).apply {

                    this.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                        override fun onReady(youTubePlayer: YouTubePlayer) {
                            super.onReady(youTubePlayer)
                            youTubePlayer.cueVideo(youtubeVideoID, 0F)
                        }
                    })

                }
            }
        )
    }
}