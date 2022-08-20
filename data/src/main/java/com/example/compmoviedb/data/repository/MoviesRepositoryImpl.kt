package com.example.compmoviedb.data.repository

import com.example.compmoviedb.data.mappers.remote.movieactors.ListActorsMovieEntityMapper
import com.example.compmoviedb.data.mappers.remote.moviedetails.MovieDetailsEntityMapper
import com.example.compmoviedb.data.mappers.remote.moviespopular.ListMoviesPopularEntityMapper
import com.example.compmoviedb.data.mappers.remote.movievideo.MovieVideoEntityMapper
import com.example.compmoviedb.data.remote.dataSource.MoviesDataSource
import com.example.compmoviedb.domain.models.Response
import com.example.compmoviedb.domain.models.movieactors.ListActorsMovieD
import com.example.compmoviedb.domain.models.moviedetails.MovieDetailsD
import com.example.compmoviedb.domain.models.moviespopular.ListMoviesPopularD
import com.example.compmoviedb.domain.models.movievideo.MovieVideoD
import com.example.compmoviedb.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

class MoviesRepositoryImpl(private val moviesStorage: MoviesDataSource) : MoviesRepository {

    override suspend fun getMoviesPopular(): Flow<Response<ListMoviesPopularD>> =
        moviesStorage.getMoviesPopular().transform { response ->
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

    override suspend fun getMovieDetailsById(movieId: Int): Flow<Response<MovieDetailsD>> =
        moviesStorage.getMovieDetailsById(movieId = movieId).transform { response ->
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

    override suspend fun getListVideoMovieById(movieId: Int): Flow<Response<MovieVideoD>> =
        moviesStorage.getListVideoMovieById(movieId = movieId).transform { response ->
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

    override suspend fun getListActorsMovieById(movieId: Int): Flow<Response<ListActorsMovieD>> =
        moviesStorage.getListActorsMovieById(movieId = movieId).transform { response ->
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