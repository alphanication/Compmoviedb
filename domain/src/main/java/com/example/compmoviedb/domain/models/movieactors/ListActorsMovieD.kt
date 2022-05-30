package com.example.compmoviedb.domain.models.movieactors

data class ListActorsMovieD(
    val cast: List<CastD>,
    val crew: List<CrewD>,
    val id: Int
)