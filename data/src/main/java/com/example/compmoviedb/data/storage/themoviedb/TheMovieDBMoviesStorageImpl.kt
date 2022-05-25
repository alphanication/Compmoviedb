package com.example.compmoviedb.data.storage.themoviedb

import com.example.compmoviedb.data.mappers.ListMoviesPopularEntityMapper
import com.example.compmoviedb.data.storage.MoviesStorage
import com.example.compmoviedb.data.storage.models.ListMoviesPopularEntity
import com.example.compmoviedb.domain.models.moviespopular.ListMoviesPopularD
import com.example.compmoviedb.domain.models.Response
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Callback

class TheMovieDBMoviesStorageImpl(private val movieDBApiInterface: MovieDBApiInterface) : MoviesStorage {
    override suspend fun getMoviesPopular(): Flow<Response<ListMoviesPopularD>> = callbackFlow {
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
                        if (it != null) trySend(Response.Success(ListMoviesPopularEntityMapper().mapFromEntity(it)))
                    }
                }

                override fun onFailure(call: Call<ListMoviesPopularEntity>, t: Throwable) {
                    trySend(Response.Fail(e = t as Exception))
                }
            })

        awaitClose { this.cancel() }
    }
}