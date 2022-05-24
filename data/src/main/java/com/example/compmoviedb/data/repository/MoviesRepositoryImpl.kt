package com.example.compmoviedb.data.repository

import com.example.compmoviedb.data.storage.MoviesStorage
import com.example.compmoviedb.domain.models.ListMoviesPopular
import com.example.compmoviedb.domain.models.Response
import com.example.compmoviedb.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class MoviesRepositoryImpl(private val moviesStorage: MoviesStorage) : MoviesRepository {

    override suspend fun getMoviesPopular(): Flow<Response<ListMoviesPopular>> {
        return moviesStorage.getMoviesPopular()
    }
}