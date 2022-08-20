package com.example.compmoviedb.data.models.moviespopular

data class ListMoviesPopularEntity(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)