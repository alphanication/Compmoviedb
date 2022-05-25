package com.example.compmoviedb.data.mappers.moviespopular

import com.example.compmoviedb.data.mappers.MapperData
import com.example.compmoviedb.domain.models.moviespopular.MoviePopularDetailsD
import com.example.compmoviedb.data.storage.models.Result

class ResultEntityMapper : MapperData<List<Result>, List<MoviePopularDetailsD>> {
    override fun mapFromEntity(type: List<Result>): List<MoviePopularDetailsD> {
        val listResult = ArrayList<MoviePopularDetailsD>()

        type.forEach { resultEntity ->
            listResult.add(
                MoviePopularDetailsD(
                    adult = resultEntity.adult,
                    backdrop_path = resultEntity.backdrop_path,
                    genre_ids = resultEntity.genre_ids,
                    id = resultEntity.id,
                    original_language = resultEntity.original_language,
                    original_title = resultEntity.original_title,
                    overview = resultEntity.overview,
                    popularity = resultEntity.popularity,
                    poster_path = resultEntity.poster_path,
                    release_date = resultEntity.release_date,
                    title = resultEntity.title,
                    video = resultEntity.video,
                    vote_average = resultEntity.vote_average,
                    vote_count = resultEntity.vote_count
                )
            )
        }

        return listResult.toList()
    }
}