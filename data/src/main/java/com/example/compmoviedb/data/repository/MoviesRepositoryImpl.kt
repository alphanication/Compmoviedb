package com.example.compmoviedb.data.repository

import com.example.compmoviedb.data.mappers.moviedetails.MovieDetailsEntityMapper
import com.example.compmoviedb.data.mappers.moviespopular.ListMoviesPopularEntityMapper
import com.example.compmoviedb.data.storage.MoviesStorage
import com.example.compmoviedb.domain.models.Response
import com.example.compmoviedb.domain.models.moviedetails.MovieDetailsD
import com.example.compmoviedb.domain.models.moviespopular.ListMoviesPopularD
import com.example.compmoviedb.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

class MoviesRepositoryImpl(private val moviesStorage: MoviesStorage) : MoviesRepository {

    override suspend fun getMoviesPopular(): Flow<Response<ListMoviesPopularD>> {
        return moviesStorage.getMoviesPopular().transform { response ->
            when (response) {
                is Response.Loading -> emit(Response.Loading())
                is Response.Fail -> emit(Response.Fail(e = response.e))
                is Response.Success -> emit(
                    Response.Success(
                        data = ListMoviesPopularEntityMapper().mapFromEntity(type = response.data)
                    )
                )
            }
        }
    }

    override suspend fun getMovieDetailsById(movieId: Int): Flow<Response<MovieDetailsD>> {
        return moviesStorage.getMovieDetailsById(movieId = movieId).transform { response ->
            when (response) {
                is Response.Loading -> emit(Response.Loading())
                is Response.Fail -> emit(Response.Fail(e = response.e))
                is Response.Success -> emit(
                    Response.Success(
                        data = MovieDetailsEntityMapper().mapFromEntity(response.data)
                    )
                )
            }
        }
    }
}