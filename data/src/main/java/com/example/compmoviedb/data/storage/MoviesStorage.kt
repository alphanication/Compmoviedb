package com.example.compmoviedb.data.storage

import com.example.compmoviedb.data.storage.models.movieactors.ListActorsMovieEntity
import com.example.compmoviedb.data.storage.models.moviedetails.MovieDetailsEntity
import com.example.compmoviedb.data.storage.models.moviespopular.ListMoviesPopularEntity
import com.example.compmoviedb.data.storage.models.movievideo.MovieVideoEntity
import com.example.compmoviedb.domain.models.Response
import kotlinx.coroutines.flow.Flow

interface MoviesStorage {
    suspend fun getMoviesPopular(): Flow<Response<ListMoviesPopularEntity>>

    suspend fun getMovieDetailsById(movieId: Int): Flow<Response<MovieDetailsEntity>>

    suspend fun getListMovieVideoById(movieId: Int): Flow<Response<MovieVideoEntity>>

    suspend fun getListActorsMovieById(movieId: Int): Flow<Response<ListActorsMovieEntity>>
}