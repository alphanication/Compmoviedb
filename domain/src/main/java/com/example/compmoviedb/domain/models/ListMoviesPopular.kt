package com.example.compmoviedb.domain.models

data class ListMoviesPopular(
    val page: Int,
    val moviesPopularDetails: List<MoviePopularDetails>,
    val total_pages: Int,
    val total_results: Int
)