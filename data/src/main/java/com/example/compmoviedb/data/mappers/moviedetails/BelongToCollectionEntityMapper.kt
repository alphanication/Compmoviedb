package com.example.compmoviedb.data.mappers.moviedetails

import com.example.compmoviedb.data.mappers.MapperData
import com.example.compmoviedb.data.storage.models.moviedetails.BelongsToCollection
import com.example.compmoviedb.domain.models.moviedetails.BelongsToCollectionD

class BelongToCollectionEntityMapper : MapperData<BelongsToCollection, BelongsToCollectionD> {

    override fun mapFromEntity(type: BelongsToCollection): BelongsToCollectionD {

        return BelongsToCollectionD(
                backdrop_path = type.backdrop_path ?: "",
                id = type.id ?: 0,
                name = type.name ?: "",
                poster_path = type.poster_path ?: ""
        )
    }
}