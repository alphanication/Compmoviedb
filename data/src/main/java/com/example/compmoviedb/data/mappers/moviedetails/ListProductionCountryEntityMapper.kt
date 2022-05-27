package com.example.compmoviedb.data.mappers.moviedetails

import com.example.compmoviedb.data.mappers.MapperData
import com.example.compmoviedb.data.storage.models.moviedetails.ProductionCountry
import com.example.compmoviedb.domain.models.moviedetails.ProductionCountryD

class ListProductionCountryEntityMapper :
    MapperData<List<ProductionCountry>, List<ProductionCountryD>> {

    override fun mapFromEntity(type: List<ProductionCountry>): List<ProductionCountryD> {
        val listProductionCompanyD = ArrayList<ProductionCountryD>()

        type.forEach { productionCountry ->
            listProductionCompanyD.add(
                ProductionCountryD(
                    iso_3166_1 = productionCountry.iso_3166_1 ?: "",
                    name = productionCountry.name ?: ""
                )
            )
        }

        return listProductionCompanyD.toList()
    }
}