package com.example.compmoviedb.data.mappers.movievideo

import com.example.compmoviedb.data.mappers.MapperData
import com.example.compmoviedb.data.dataSource.models.movievideo.Result
import com.example.compmoviedb.domain.models.movievideo.ResultMovieVideoDetailsD

class ResultListMovieVideoMapper : MapperData<List<Result>, List<ResultMovieVideoDetailsD>> {

    override fun mapFromEntity(type: List<Result>): List<ResultMovieVideoDetailsD> {
        val listResultMovieVideoDetailsD = ArrayList<ResultMovieVideoDetailsD>()

        type.forEach { result ->
            listResultMovieVideoDetailsD.add(
                ResultMovieVideoDetailsD(
                    id = result.id ?: "",
                    iso_3166_1 = result.iso_3166_1 ?: "",
                    iso_639_1 = result.iso_639_1 ?: "",
                    key = result.key ?: "",
                    name = result.name ?: "",
                    official = result.official ?: false,
                    published_at = result.published_at ?: "",
                    site = result.site ?: "",
                    size = result.size ?: 0,
                    type = result.type ?: ""
                )
            )
        }

        return listResultMovieVideoDetailsD.toList()
    }
}