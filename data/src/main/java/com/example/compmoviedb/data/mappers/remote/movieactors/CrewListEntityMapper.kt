package com.example.compmoviedb.data.mappers.remote.movieactors

import com.example.compmoviedb.data.mappers.MapperData
import com.example.compmoviedb.data.models.remote.movieactors.Crew
import com.example.compmoviedb.domain.models.movieactors.CrewD

class CrewListEntityMapper : MapperData<List<Crew>, List<CrewD>> {

    override fun mapFromEntity(type: List<Crew>): List<CrewD> {
        val listCrewD = ArrayList<CrewD>()

        type.forEach { crew ->
            listCrewD.add(
                CrewD(
                    adult = crew.adult ?: false,
                    credit_id = crew.credit_id ?: "",
                    department = crew.department ?: "",
                    gender = crew.gender ?: 0,
                    id = crew.id ?: 0,
                    job = crew.job ?: "",
                    known_for_department = crew.known_for_department ?: "",
                    name = crew.name ?: "",
                    original_name = crew.original_name ?: "",
                    popularity = crew.popularity ?: 0.0,
                    profile_path = crew.profile_path ?: ""
                )
            )
        }

        return listCrewD.toList()
    }
}