package com.example.compmoviedb.data.mappers.remote.movievideo

import com.example.compmoviedb.data.mappers.MapperData
import com.example.compmoviedb.data.models.remote.movievideo.MovieVideoEntity
import com.example.compmoviedb.domain.models.movievideo.MovieVideoD

class MovieVideoEntityMapper : MapperData<MovieVideoEntity, MovieVideoD> {

    override fun mapFromEntity(type: MovieVideoEntity): MovieVideoD {
        return MovieVideoD(
            id = type.id ?: 0,
            resultMovieVideoDetailsDS = ResultListMovieVideoMapper()
                .mapFromEntity(type = type.results ?: listOf())
        )
    }
}