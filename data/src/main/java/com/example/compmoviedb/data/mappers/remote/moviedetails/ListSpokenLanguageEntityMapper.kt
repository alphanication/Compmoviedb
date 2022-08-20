package com.example.compmoviedb.data.mappers.remote.moviedetails

import com.example.compmoviedb.data.mappers.MapperData
import com.example.compmoviedb.data.models.remote.moviedetails.SpokenLanguage
import com.example.compmoviedb.domain.models.moviedetails.SpokenLanguageD

class ListSpokenLanguageEntityMapper : MapperData<List<SpokenLanguage>, List<SpokenLanguageD>> {

    override fun mapFromEntity(type: List<SpokenLanguage>): List<SpokenLanguageD> {
        val listSpokenLanguageD = ArrayList<SpokenLanguageD>()

        type.forEach { spokenLanguage ->
            listSpokenLanguageD.add(
                SpokenLanguageD(
                    iso_639_1 = spokenLanguage.iso_639_1 ?: "",
                    name = spokenLanguage.name ?: ""
                )
            )
        }

        return listSpokenLanguageD.toList()
    }
}