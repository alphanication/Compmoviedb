package com.example.compmoviedb.di

import com.example.compmoviedb.domain.repository.MoviesRepository
import com.example.compmoviedb.domain.usecase.GetListMoviesPopularUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun providesGetListMoviesPopularUseCase(moviesRepository: MoviesRepository) : GetListMoviesPopularUseCase {
        return GetListMoviesPopularUseCase(moviesRepository = moviesRepository)
    }
}