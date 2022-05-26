package com.example.compmoviedb.data.mappers.moviedetails

import com.example.compmoviedb.data.mappers.MapperData
import com.example.compmoviedb.data.storage.models.moviedetails.MovieDetailsEntity
import com.example.compmoviedb.domain.models.moviedetails.MovieDetailsD

class MovieDetailsEntityMapper : MapperData<MovieDetailsEntity, MovieDetailsD> {

    override fun mapFromEntity(type: MovieDetailsEntity): MovieDetailsD {

        return MovieDetailsD(
            adult = type.adult,
            backdrop_path = type.backdrop_path,
            belongs_to_collection = BelongToCollectionEntityMapper()
                .mapFromEntity(type = type.belongs_to_collection),
            budget = type.budget,
            genreMS = ListGenreEntityMapper().mapFromEntity(type = type.genres),
            homepage = type.homepage,
            id = type.id,
            imdb_id = type.imdb_id,
            original_language = type.original_language,
            original_title = type.original_title,
            overview = type.overview,
            popularity = type.popularity,
            poster_path = type.poster_path,
            production_companies = ListProductionCompanyEntityMapper()
                .mapFromEntity(type = type.production_companies),
            production_countries = ListProductionCountryEntityMapper()
                .mapFromEntity(type = type.production_countries),
            release_date = type.release_date,
            revenue = type.revenue,
            runtime = type.runtime,
            spoken_languages = ListSpokenLanguageEntityMapper()
                .mapFromEntity(type = type.spoken_languages),
            status = type.status,
            tagline = type.tagline,
            title = type.title,
            video = type.video,
            vote_average = type.vote_average,
            vote_count = type.vote_count
        )
    }
}