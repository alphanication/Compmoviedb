package com.example.compmoviedb.data.mappers.moviespopular

import com.example.compmoviedb.data.mappers.MapperData
import com.example.compmoviedb.data.storage.models.ListMoviesPopularEntity
import com.example.compmoviedb.domain.models.moviespopular.ListMoviesPopularD

class ListMoviesPopularEntityMapper : MapperData<ListMoviesPopularEntity, ListMoviesPopularD> {
    override fun mapFromEntity(type: ListMoviesPopularEntity): ListMoviesPopularD {
        return ListMoviesPopularD(
            page = type.page,
            moviesPopularDetails = ResultEntityMapper().mapFromEntity(type.results),
            total_pages = type.total_pages,
            total_results = type.total_results
        )
    }
}