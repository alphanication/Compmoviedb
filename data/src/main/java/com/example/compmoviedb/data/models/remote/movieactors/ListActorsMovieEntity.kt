package com.example.compmoviedb.data.models.remote.movieactors

data class ListActorsMovieEntity(
    val cast: List<Cast>?,
    val crew: List<Crew>?,
    val id: Int?
)