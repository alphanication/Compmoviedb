package com.example.compmoviedb.data.mappers.moviedetails

import com.example.compmoviedb.data.mappers.MapperData
import com.example.compmoviedb.data.models.moviedetails.BelongsToCollection
import com.example.compmoviedb.data.models.moviedetails.MovieDetailsEntity
import com.example.compmoviedb.domain.models.moviedetails.MovieDetailsD

class MovieDetailsEntityMapper : MapperData<MovieDetailsEntity, MovieDetailsD> {

    override fun mapFromEntity(type: MovieDetailsEntity): MovieDetailsD {

        return MovieDetailsD(
            adult = type.adult ?: false,
            backdrop_path = type.backdrop_path ?: "",
            belongs_to_collection = BelongToCollectionEntityMapper()
                .mapFromEntity(
                    type = type.belongs_to_collection ?: BelongsToCollection(
                        backdrop_path = "",
                        id = 0,
                        name = "",
                        poster_path = ""
                    )
                ),
            budget = type.budget ?: 0,
            genreMS = ListGenreEntityMapper().mapFromEntity(type = type.genres ?: listOf()),
            homepage = type.homepage ?: "",
            id = type.id ?: 0,
            imdb_id = type.imdb_id ?: "",
            original_language = type.original_language ?: "",
            original_title = type.original_title ?: "",
            overview = type.overview ?: "",
            popularity = type.popularity ?: 0.0,
            poster_path = type.poster_path ?: "",
            production_companies = ListProductionCompanyEntityMapper()
                .mapFromEntity(type = type.production_companies ?: listOf()),
            production_countries = ListProductionCountryEntityMapper()
                .mapFromEntity(type = type.production_countries ?: listOf()),
            release_date = type.release_date ?: "",
            revenue = type.revenue ?: 0,
            runtime = type.runtime ?: 0,
            spoken_languages = ListSpokenLanguageEntityMapper()
                .mapFromEntity(type = type.spoken_languages ?: listOf()),
            status = type.status ?: "",
            tagline = type.tagline ?: "",
            title = type.title ?: "",
            video = type.video ?: false,
            vote_average = type.vote_average ?: 0.0,
            vote_count = type.vote_count ?: 0
        )
    }
}