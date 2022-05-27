package com.example.compmoviedb.domain.usecase

import com.example.compmoviedb.domain.models.Response
import com.example.compmoviedb.domain.models.movievideo.MovieVideoD
import com.example.compmoviedb.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class GetListMovieVideoByIdUseCase(private val moviesRepository: MoviesRepository) {
    suspend fun execute(movieId: Int): Flow<Response<MovieVideoD>> {
        return moviesRepository.getListMovieVideoById(movieId = movieId)
    }
}