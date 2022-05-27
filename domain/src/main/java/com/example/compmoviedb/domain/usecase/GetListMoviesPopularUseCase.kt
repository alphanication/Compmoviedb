package com.example.compmoviedb.domain.usecase

import com.example.compmoviedb.domain.models.Response
import com.example.compmoviedb.domain.models.moviespopular.ListMoviesPopularD
import com.example.compmoviedb.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class GetListMoviesPopularUseCase(private val moviesRepository: MoviesRepository) {
    suspend fun execute(): Flow<Response<ListMoviesPopularD>> {
        return moviesRepository.getMoviesPopular()
    }
}