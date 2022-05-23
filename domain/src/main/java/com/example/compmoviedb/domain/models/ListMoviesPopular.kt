package com.example.compmoviedb.domain.models

data class ListMoviesPopular(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)