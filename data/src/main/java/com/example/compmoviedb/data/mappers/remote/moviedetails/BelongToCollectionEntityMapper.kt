package com.example.compmoviedb.data.mappers.remote.moviedetails

import com.example.compmoviedb.data.mappers.MapperData
import com.example.compmoviedb.data.models.remote.moviedetails.BelongsToCollection
import com.example.compmoviedb.domain.models.moviedetails.BelongsToCollectionD

class BelongToCollectionEntityMapper : MapperData<BelongsToCollection, BelongsToCollectionD> {

    override fun mapFromEntity(type: BelongsToCollection): BelongsToCollectionD =
        BelongsToCollectionD(
            backdrop_path = type.backdrop_path ?: "",
            id = type.id ?: 0,
            name = type.name ?: "",
            poster_path = type.poster_path ?: ""
        )
}