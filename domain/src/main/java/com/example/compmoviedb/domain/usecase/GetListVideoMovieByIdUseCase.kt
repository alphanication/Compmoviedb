package com.example.compmoviedb.domain.usecase

import com.example.compmoviedb.domain.models.Response
import com.example.compmoviedb.domain.models.movievideo.MovieVideoD
import com.example.compmoviedb.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class GetListVideoMovieByIdUseCase(private val moviesRepository: MoviesRepository) {
    suspend fun execute(movieId: Int): Flow<Response<MovieVideoD>> =
        moviesRepository.getListVideoMovieById(movieId = movieId)
}