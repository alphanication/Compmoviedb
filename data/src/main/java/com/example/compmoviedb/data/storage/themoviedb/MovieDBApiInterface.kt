package com.example.compmoviedb.data.storage.themoviedb

import com.example.compmoviedb.data.storage.models.moviedetails.MovieDetailsEntity
import com.example.compmoviedb.data.storage.models.moviespopular.ListMoviesPopularEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDBApiInterface {
    @GET("3/movie/popular")
    fun getListPopularMovies(
        @Query("api_key") key: String,
        @Query("language") language: String
    ): Call<ListMoviesPopularEntity>

    @GET("3/movie/{movie_id}")
    fun getMovieDetailsById(
        @Path("movie_id") movieId: Int,
        @Query("api_key") key: String,
        @Query("language") language: String
    ): Call<MovieDetailsEntity>
}