package com.example.compmoviedb.data.repository

import com.example.compmoviedb.data.mappers.movieactors.ListActorsMovieEntityMapper
import com.example.compmoviedb.data.mappers.moviedetails.MovieDetailsEntityMapper
import com.example.compmoviedb.data.mappers.moviespopular.ListMoviesPopularEntityMapper
import com.example.compmoviedb.data.mappers.movievideo.MovieVideoEntityMapper
import com.example.compmoviedb.data.dataSource.MoviesDataSource
import com.example.compmoviedb.domain.models.Response
import com.example.compmoviedb.domain.models.movieactors.ListActorsMovieD
import com.example.compmoviedb.domain.models.moviedetails.MovieDetailsD
import com.example.compmoviedb.domain.models.moviespopular.ListMoviesPopularD
import com.example.compmoviedb.domain.models.movievideo.MovieVideoD
import com.example.compmoviedb.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

class MoviesRepositoryImpl(private val moviesStorage: MoviesDataSource) : MoviesRepository {

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
                        data = MovieDetailsEntityMapper().mapFromEntity(type = response.data)
                    )
                )
            }
        }
    }

    override suspend fun getListMovieVideoById(movieId: Int): Flow<Response<MovieVideoD>> {
        return moviesStorage.getListMovieVideoById(movieId = movieId).transform { response ->
            when (response) {
                is Response.Loading -> emit(Response.Loading())
                is Response.Fail -> emit(Response.Fail(e = response.e))
                is Response.Success -> emit(
                    Response.Success(
                        MovieVideoEntityMapper().mapFromEntity(type = response.data)
                    )
                )
            }
        }
    }

    override suspend fun getListActorsMovieById(movieId: Int): Flow<Response<ListActorsMovieD>> {
        return moviesStorage.getListActorsMovieById(movieId = movieId).transform { response ->
            when (response) {
                is Response.Loading -> emit(Response.Loading())
                is Response.Fail -> emit(Response.Fail(e = response.e))
                is Response.Success -> emit(
                    Response.Success(
                        data = ListActorsMovieEntityMapper().mapFromEntity(type = response.data)
                    )
                )
            }
        }
    }
}