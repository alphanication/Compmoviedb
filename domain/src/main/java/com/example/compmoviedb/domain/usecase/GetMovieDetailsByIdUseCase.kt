package com.example.compmoviedb.domain.usecase

import com.example.compmoviedb.domain.models.Response
import com.example.compmoviedb.domain.models.moviedetails.MovieDetailsD
import com.example.compmoviedb.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class GetMovieDetailsByIdUseCase(private val moviesRepository: MoviesRepository) {
    suspend fun execute(movieId: Int) : Flow<Response<MovieDetailsD>> {
        return moviesRepository.getMovieDetailsById(movieId = movieId)
    }
}