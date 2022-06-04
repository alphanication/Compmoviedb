package com.example.compmoviedb.domain.usecase

import com.example.compmoviedb.domain.models.Response
import com.example.compmoviedb.domain.models.movieactors.ListActorsMovieD
import com.example.compmoviedb.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class GetListActorsMovieByIdUseCase(private val moviesRepository: MoviesRepository) {
    suspend fun execute(movieId: Int): Flow<Response<ListActorsMovieD>> {
        return moviesRepository.getListActorsMovieById(movieId = movieId)
    }
}