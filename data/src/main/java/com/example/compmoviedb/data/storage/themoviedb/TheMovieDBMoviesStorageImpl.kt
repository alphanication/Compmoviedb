package com.example.compmoviedb.data.storage.themoviedb

import com.example.compmoviedb.data.mappers.ListMoviesPopularEntityMapper
import com.example.compmoviedb.data.storage.MoviesStorage
import com.example.compmoviedb.data.storage.models.ListMoviesPopularEntity
import com.example.compmoviedb.domain.models.ListMoviesPopular
import com.example.compmoviedb.domain.models.Response
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Callback

class TheMovieDBMoviesStorageImpl(private val movieDBApiInterface: MovieDBApiInterface) : MoviesStorage {
    override suspend fun getMoviesPopular(): Flow<Response<ListMoviesPopular>> = callbackFlow {
        trySend(Response.Loading())

        movieDBApiInterface.getListPopularMovies("e57c71791b41b1b6d48678746aa69e44", "ru")
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