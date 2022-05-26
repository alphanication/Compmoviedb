package com.example.compmoviedb.data.mappers.moviedetails

import com.example.compmoviedb.data.mappers.MapperData
import com.example.compmoviedb.data.storage.models.moviedetails.Genre
import com.example.compmoviedb.domain.models.moviedetails.GenreD

class ListGenreEntityMapper : MapperData<List<Genre>, List<GenreD>> {

    override fun mapFromEntity(type: List<Genre>): List<GenreD> {
        val listGenreD = ArrayList<GenreD>()

        type.forEach { genre ->
            listGenreD.add(
                GenreD(
                    id = genre.id ?: 0,
                    name = genre.name ?: ""
                )
            )
        }

        return listGenreD.toList()
    }
}