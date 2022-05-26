package com.example.compmoviedb.data.mappers.moviedetails

import android.util.Log
import com.example.compmoviedb.data.mappers.MapperData
import com.example.compmoviedb.data.storage.models.moviedetails.BelongsToCollection
import com.example.compmoviedb.domain.models.moviedetails.BelongsToCollectionD

class BelongToCollectionEntityMapper : MapperData<BelongsToCollection?, BelongsToCollectionD> {

    override fun mapFromEntity(type: BelongsToCollection?): BelongsToCollectionD {
        var belongToCollectionD: BelongsToCollectionD = BelongsToCollectionD(
            backdrop_path = "",
            id = 0,
            name = "",
            poster_path = ""
        )

        if (type != null) {
            belongToCollectionD = BelongsToCollectionD(
                backdrop_path = type.backdrop_path,
                id = type.id,
                name = type.name,
                poster_path = type.poster_path
            )
        }

        return belongToCollectionD
    }
}