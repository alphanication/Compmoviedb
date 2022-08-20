package com.example.compmoviedb.data.remote.dataSource

import com.example.compmoviedb.data.models.movieactors.ListActorsMovieEntity
import com.example.compmoviedb.data.models.moviedetails.MovieDetailsEntity
import com.example.compmoviedb.data.models.moviespopular.ListMoviesPopularEntity
import com.example.compmoviedb.data.models.movievideo.MovieVideoEntity
import com.example.compmoviedb.domain.models.Response
import kotlinx.coroutines.flow.Flow

interface MoviesDataSource {
    suspend fun getMoviesPopular(): Flow<Response<ListMoviesPopularEntity>>

    suspend fun getMovieDetailsById(movieId: Int): Flow<Response<MovieDetailsEntity>>

    suspend fun getListMovieVideoById(movieId: Int): Flow<Response<MovieVideoEntity>>

    suspend fun getListActorsMovieById(movieId: Int): Flow<Response<ListActorsMovieEntity>>
}