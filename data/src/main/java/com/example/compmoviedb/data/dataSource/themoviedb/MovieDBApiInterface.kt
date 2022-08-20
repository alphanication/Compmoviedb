package com.example.compmoviedb.data.dataSource.themoviedb

import com.example.compmoviedb.data.dataSource.models.movieactors.ListActorsMovieEntity
import com.example.compmoviedb.data.dataSource.models.moviedetails.MovieDetailsEntity
import com.example.compmoviedb.data.dataSource.models.moviespopular.ListMoviesPopularEntity
import com.example.compmoviedb.data.dataSource.models.movievideo.MovieVideoEntity
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

    @GET("3/movie/{movie_id}/videos")
    fun getListMovieVideoById(
        @Path("movie_id") movieId: Int,
        @Query("api_key") key: String,
        @Query("language") language: String
    ): Call<MovieVideoEntity>

    @GET("3/movie/{movie_id}/credits")
    fun getListActorsMovieById(
        @Path("movie_id") movieId: Int,
        @Query("api_key") key: String,
        @Query("language") language: String
    ): Call<ListActorsMovieEntity>

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/"
    }
}