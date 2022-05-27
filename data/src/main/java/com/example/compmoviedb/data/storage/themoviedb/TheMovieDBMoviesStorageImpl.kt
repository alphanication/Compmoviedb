package com.example.compmoviedb.data.storage.themoviedb

import com.example.compmoviedb.data.storage.MoviesStorage
import com.example.compmoviedb.data.storage.models.moviedetails.MovieDetailsEntity
import com.example.compmoviedb.data.storage.models.moviespopular.ListMoviesPopularEntity
import com.example.compmoviedb.data.storage.models.movievideo.MovieVideoEntity
import com.example.compmoviedb.domain.models.Response
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Callback

class TheMovieDBMoviesStorageImpl(private val movieDBApiInterface: MovieDBApiInterface) :
    MoviesStorage {

    override suspend fun getMoviesPopular(): Flow<Response<ListMoviesPopularEntity>> =
        callbackFlow {
            trySend(Response.Loading())

            movieDBApiInterface.getListPopularMovies(
                key = MovieDBConstants.MOVIE_DB_KEY,
                language = MovieDBConstants.LANGUAGE_RU
            )
                .enqueue(object : Callback<ListMoviesPopularEntity> {

                    override fun onResponse(
                        call: Call<ListMoviesPopularEntity>,
                        response: retrofit2.Response<ListMoviesPopularEntity>
                    ) {
                        response.body().let {
                            if (it != null) trySend(Response.Success(data = it))
                        }
                    }

                    override fun onFailure(call: Call<ListMoviesPopularEntity>, t: Throwable) {
                        trySend(Response.Fail(e = t as Exception))
                    }
                })

            awaitClose { this.cancel() }
        }

    override suspend fun getMovieDetailsById(movieId: Int): Flow<Response<MovieDetailsEntity>> =
        callbackFlow {
            trySend(Response.Loading())

            movieDBApiInterface.getMovieDetailsById(
                movieId = movieId,
                key = MovieDBConstants.MOVIE_DB_KEY,
                language = MovieDBConstants.LANGUAGE_RU
            ).enqueue(object : Callback<MovieDetailsEntity> {
                override fun onResponse(
                    call: Call<MovieDetailsEntity>,
                    response: retrofit2.Response<MovieDetailsEntity>
                ) {
                    response.body().let {
                        if (it != null) trySend(Response.Success(data = it))
                    }
                }

                override fun onFailure(call: Call<MovieDetailsEntity>, t: Throwable) {
                    trySend(Response.Fail(e = t as Exception))
                }
            })

            awaitClose { this.cancel() }
        }

    override suspend fun getListMovieVideoById(movieId: Int): Flow<Response<MovieVideoEntity>> =
        callbackFlow {
            trySend(Response.Loading())

            movieDBApiInterface.getListMovieVideoById(
                movieId = movieId,
                key = MovieDBConstants.MOVIE_DB_KEY,
                language = MovieDBConstants.LANGUAGE_RU
            ).enqueue(object : Callback<MovieVideoEntity> {
                override fun onResponse(
                    call: Call<MovieVideoEntity>,
                    response: retrofit2.Response<MovieVideoEntity>
                ) {
                    response.body().let {
                        if (it != null) trySend(Response.Success(data = it))
                    }
                }

                override fun onFailure(call: Call<MovieVideoEntity>, t: Throwable) {
                    trySend(Response.Fail(e = t as Exception))
                }
            })

            awaitClose { this.cancel() }
        }
}