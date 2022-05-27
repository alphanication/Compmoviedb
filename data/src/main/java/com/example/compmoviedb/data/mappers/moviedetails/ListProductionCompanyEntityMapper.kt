package com.example.compmoviedb.data.mappers.moviedetails

import com.example.compmoviedb.data.mappers.MapperData
import com.example.compmoviedb.data.storage.models.moviedetails.ProductionCompany
import com.example.compmoviedb.domain.models.moviedetails.ProductionCompanyD

class ListProductionCompanyEntityMapper :
    MapperData<List<ProductionCompany>, List<ProductionCompanyD>> {

    override fun mapFromEntity(type: List<ProductionCompany>): List<ProductionCompanyD> {
        val listProductionCompanyD = ArrayList<ProductionCompanyD>()

        type.forEach { productionCompany ->
            listProductionCompanyD.add(
                ProductionCompanyD(
                    id = productionCompany.id ?: 0,
                    logo_path = productionCompany.logo_path ?: "",
                    name = productionCompany.name ?: "",
                    origin_country = productionCompany.origin_country ?: ""
                )
            )
        }

        return listProductionCompanyD.toList()
    }
}