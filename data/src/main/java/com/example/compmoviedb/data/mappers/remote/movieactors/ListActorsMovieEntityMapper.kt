package com.example.compmoviedb.data.mappers.remote.movieactors

import com.example.compmoviedb.data.mappers.MapperData
import com.example.compmoviedb.data.models.remote.movieactors.ListActorsMovieEntity
import com.example.compmoviedb.domain.models.movieactors.ListActorsMovieD

class ListActorsMovieEntityMapper : MapperData<ListActorsMovieEntity, ListActorsMovieD> {

    override fun mapFromEntity(type: ListActorsMovieEntity): ListActorsMovieD =
        ListActorsMovieD(
            cast = CastListEntityMapper().mapFromEntity(type = type.cast ?: listOf()),
            crew = CrewListEntityMapper().mapFromEntity(type = type.crew ?: listOf()),
            id = type.id ?: 0
        )
}