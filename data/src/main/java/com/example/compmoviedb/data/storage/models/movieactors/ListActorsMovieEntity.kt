package com.example.compmoviedb.data.storage.models.movieactors

data class ListActorsMovieEntity(
    val cast: List<Cast>?,
    val crew: List<Crew>?,
    val id: Int?
)