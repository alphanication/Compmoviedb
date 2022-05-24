package com.example.compmoviedb.data.storage.themoviedb

import com.example.compmoviedb.data.storage.models.ListMoviesPopularEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDBApiInterface {
    @GET("3/movie/popular")
    fun getListPopularMovies(@Query("api_key") key: String, @Query("language") language: String) : Call<ListMoviesPopularEntity>
}