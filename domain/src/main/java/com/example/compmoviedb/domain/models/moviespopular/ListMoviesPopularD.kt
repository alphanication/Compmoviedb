package com.example.compmoviedb.domain.models.moviespopular

data class ListMoviesPopularD(
    val page: Int,
    val moviesPopularDetails: List<MoviePopularDetailsD>,
    val total_pages: Int,
    val total_results: Int
)