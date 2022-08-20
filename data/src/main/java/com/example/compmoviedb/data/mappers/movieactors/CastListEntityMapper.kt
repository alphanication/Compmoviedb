package com.example.compmoviedb.data.mappers.movieactors

import com.example.compmoviedb.data.mappers.MapperData
import com.example.compmoviedb.data.dataSource.models.movieactors.Cast
import com.example.compmoviedb.domain.models.movieactors.CastD

class CastListEntityMapper : MapperData<List<Cast>, List<CastD>> {

    override fun mapFromEntity(type: List<Cast>): List<CastD> {
        val listCastD = ArrayList<CastD>()

        type.forEach { cast ->
            listCastD.add(
                CastD(
                    adult = cast.adult ?: false,
                    cast_id = cast.cast_id ?: 0,
                    character = cast.character ?: "",
                    credit_id = cast.credit_id ?: "",
                    gender = cast.gender ?: 0,
                    id = cast.id ?: 0,
                    known_for_department = cast.known_for_department ?: "",
                    name = cast.name ?: "",
                    order = cast.order ?: 0,
                    original_name = cast.original_name ?: "",
                    popularity = cast.popularity ?: 0.0,
                    profile_path = cast.profile_path ?: ""
                )
            )
        }

        return listCastD.toList()
    }
}