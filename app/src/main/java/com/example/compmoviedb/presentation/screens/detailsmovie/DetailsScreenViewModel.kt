package com.example.compmoviedb.presentation.screens.detailsmovie

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compmoviedb.domain.models.Response
import com.example.compmoviedb.domain.models.movieactors.ListActorsMovieD
import com.example.compmoviedb.domain.models.moviedetails.BelongsToCollectionD
import com.example.compmoviedb.domain.models.moviedetails.MovieDetailsD
import com.example.compmoviedb.domain.usecase.GetListActorsMovieByIdUseCase
import com.example.compmoviedb.domain.usecase.GetListMovieVideoByIdUseCase
import com.example.compmoviedb.domain.usecase.GetMovieDetailsByIdUseCase
import com.example.compmoviedb.presentation.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsMovieViewModel @Inject constructor(
    private val getMovieDetailsByIdUseCase: GetMovieDetailsByIdUseCase,
    private val getListMovieVideoByIdUseCase: GetListMovieVideoByIdUseCase,
    private val getListActorsMovieByIdUseCase: GetListActorsMovieByIdUseCase
) : ViewModel() {

    private val _movieDetails = MutableStateFlow<MovieDetailsD>(movieDetailsBase())
    val movieDetails = _movieDetails.asStateFlow()

    private val _movieVideoYoutubeID = MutableStateFlow<String>("")
    val movieVideoYoutubeID = _movieVideoYoutubeID.asStateFlow()

    private val _movieListActors = MutableStateFlow<ListActorsMovieD>(
        ListActorsMovieD(
            cast = listOf(),
            crew = listOf(),
            id = 0
        )
    )
    val movieListActors = _movieListActors.asStateFlow()

    fun getMovieDetailsById(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            getMovieDetailsByIdUseCase.execute(movieId = movieId).collect { response ->
                when (response) {
                    is Response.Loading -> {}
                    is Response.Fail -> {}
                    is Response.Success -> _movieDetails.emit(response.data)
                }
            }
        }
    }

    fun getListMovieVideo(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            getListMovieVideoByIdUseCase.execute(movieId = movieId).collect { response ->
                when (response) {
                    is Response.Loading -> {}
                    is Response.Fail -> {}
                    is Response.Success -> response.data.resultMovieVideoDetailsDS.forEach { movie ->
                        if (movieVideoYoutubeID.value.isEmpty()) {
                            if (movie.site == Constants.Keys.YOUTUBE) _movieVideoYoutubeID.emit(
                                movie.key
                            )
                        }
                    }
                }
            }
        }
    }

    fun getListActorsMovieById(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            getListActorsMovieByIdUseCase.execute(movieId = movieId).collect { response ->
                when (response) {
                    is Response.Loading -> {}
                    is Response.Fail -> {}
                    is Response.Success -> _movieListActors.emit(response.data)
                }
            }
        }
    }

    private fun movieDetailsBase(): MovieDetailsD {
        return MovieDetailsD(
            adult = false,
            backdrop_path = "",
            belongs_to_collection = BelongsToCollectionD(
                backdrop_path = "", id = 0, name = "", poster_path = ""
            ),
            budget = 0,
            genreMS = listOf(),
            homepage = "",
            id = 0,
            imdb_id = "",
            original_language = "",
            original_title = "",
            overview = "",
            popularity = 0.0,
            poster_path = "",
            production_companies = listOf(),
            production_countries = listOf(),
            release_date = "",
            revenue = 0,
            runtime = 0,
            spoken_languages = listOf(),
            status = "",
            tagline = "",
            title = "",
            video = false,
            vote_average = 0.0,
            vote_count = 0
        )
    }
}