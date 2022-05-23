package com.example.compmoviedb.domain.repository

import com.example.compmoviedb.domain.models.ListMoviesPopular
import com.example.compmoviedb.domain.models.Response
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getMoviesPopular() : Flow<Response<ListMoviesPopular>>
}