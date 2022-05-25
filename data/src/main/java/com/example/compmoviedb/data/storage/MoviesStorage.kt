package com.example.compmoviedb.data.storage

import com.example.compmoviedb.data.storage.models.ListMoviesPopularEntity
import com.example.compmoviedb.domain.models.moviespopular.ListMoviesPopularD
import com.example.compmoviedb.domain.models.Response
import kotlinx.coroutines.flow.Flow

interface MoviesStorage {
    suspend fun getMoviesPopular() : Flow<Response<ListMoviesPopularEntity>>
}