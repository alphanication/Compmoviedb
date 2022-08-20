package com.example.compmoviedb.data.remote.dataSource.themoviedb

import com.example.compmoviedb.data.models.remote.movieactors.ListActorsMovieEntity
import com.example.compmoviedb.data.models.remote.moviedetails.MovieDetailsEntity
import com.example.compmoviedb.data.models.remote.moviespopular.ListMoviesPopularEntity
import com.example.compmoviedb.data.models.remote.movievideo.MovieVideoEntity
import com.example.compmoviedb.data.remote.dataSource.themoviedb.MovieDBConstants.API_KEY_QUERY
import com.example.compmoviedb.data.remote.dataSource.themoviedb.MovieDBConstants.LANGUAGE_QUERY
import com.example.compmoviedb.data.remote.dataSource.themoviedb.MovieDBConstants.LIST_ACTORS_MOVIE_BY_ID_URL
import com.example.compmoviedb.data.remote.dataSource.themoviedb.MovieDBConstants.LIST_VIDEO_MOVIE_BY_ID_URL
import com.example.compmoviedb.data.remote.dataSource.themoviedb.MovieDBConstants.MOVIES_BY_ID_URL
import com.example.compmoviedb.data.remote.dataSource.themoviedb.MovieDBConstants.MOVIES_POPULAR_URL
import com.example.compmoviedb.data.remote.dataSource.themoviedb.MovieDBConstants.MOVIE_ID_PATH
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDBApiInterface {

    @GET(MOVIES_POPULAR_URL)
    fun getListPopularMovies(
        @Query(API_KEY_QUERY) key: String,
        @Query(LANGUAGE_QUERY) language: String
    ): Call<ListMoviesPopularEntity>

    @GET(MOVIES_BY_ID_URL)
    fun getMovieDetailsById(
        @Path(MOVIE_ID_PATH) movieId: Int,
        @Query(API_KEY_QUERY) key: String,
        @Query(LANGUAGE_QUERY) language: String
    ): Call<MovieDetailsEntity>

    @GET(LIST_VIDEO_MOVIE_BY_ID_URL)
    fun getListVideoMovieById(
        @Path(MOVIE_ID_PATH) movieId: Int,
        @Query(API_KEY_QUERY) key: String,
        @Query(LANGUAGE_QUERY) language: String
    ): Call<MovieVideoEntity>

    @GET(LIST_ACTORS_MOVIE_BY_ID_URL)
    fun getListActorsMovieById(
        @Path(MOVIE_ID_PATH) movieId: Int,
        @Query(API_KEY_QUERY) key: String,
        @Query(LANGUAGE_QUERY) language: String
    ): Call<ListActorsMovieEntity>

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/"
    }
}