package com.example.compmoviedb.domain.repository

import com.example.compmoviedb.domain.models.moviespopular.ListMoviesPopularD
import com.example.compmoviedb.domain.models.Response
import com.example.compmoviedb.domain.models.moviedetails.MovieDetailsD
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun getMoviesPopular() : Flow<Response<ListMoviesPopularD>>

    suspend fun getMovieDetailsById(movieId: Int) : Flow<Response<MovieDetailsD>>
}