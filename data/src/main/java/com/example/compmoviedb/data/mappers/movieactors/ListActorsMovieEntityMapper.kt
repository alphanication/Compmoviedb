package com.example.compmoviedb.data.mappers.movieactors

import com.example.compmoviedb.data.mappers.MapperData
import com.example.compmoviedb.data.storage.models.movieactors.ListActorsMovieEntity
import com.example.compmoviedb.domain.models.movieactors.ListActorsMovieD

class ListActorsMovieEntityMapper : MapperData<ListActorsMovieEntity, ListActorsMovieD> {

    override fun mapFromEntity(type: ListActorsMovieEntity): ListActorsMovieD {
        return ListActorsMovieD(
            cast = CastListEntityMapper().mapFromEntity(type = type.cast ?: listOf()),
            crew = CrewListEntityMapper().mapFromEntity(type = type.crew ?: listOf()),
            id = type.id ?: 0
        )
    }
}