package com.example.compmoviedb.data.storage

import com.example.compmoviedb.domain.models.ListMoviesPopular
import com.example.compmoviedb.domain.models.Response
import kotlinx.coroutines.flow.Flow

interface MoviesStorage {
    suspend fun getMoviesPopular() : Flow<Response<ListMoviesPopular>>
}