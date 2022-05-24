package com.example.compmoviedb.data.mappers

import com.example.compmoviedb.data.storage.models.ListMoviesPopularEntity
import com.example.compmoviedb.domain.models.ListMoviesPopular

class ListMoviesPopularEntityMapper : MapperData<ListMoviesPopularEntity, ListMoviesPopular> {
    override fun mapFromEntity(type: ListMoviesPopularEntity): ListMoviesPopular {
        return ListMoviesPopular(
            page = type.page,
            moviesPopularDetails = ListResultEntityMapper().mapFromEntity(type.results),
            total_pages = type.total_pages,
            total_results = type.total_results
        )
    }
}