package com.example.compmoviedb.data.remote.dataSource

import com.example.compmoviedb.data.models.remote.movieactors.ListActorsMovieEntity
import com.example.compmoviedb.data.models.remote.moviedetails.MovieDetailsEntity
import com.example.compmoviedb.data.models.remote.moviespopular.ListMoviesPopularEntity
import com.example.compmoviedb.data.models.remote.movievideo.MovieVideoEntity
import com.example.compmoviedb.domain.models.Response
import kotlinx.coroutines.flow.Flow

interface MoviesDataSource {
    suspend fun getMoviesPopular(): Flow<Response<ListMoviesPopularEntity>>

    suspend fun getMovieDetailsById(movieId: Int): Flow<Response<MovieDetailsEntity>>

    suspend fun getListVideoMovieById(movieId: Int): Flow<Response<MovieVideoEntity>>

    suspend fun getListActorsMovieById(movieId: Int): Flow<Response<ListActorsMovieEntity>>
}