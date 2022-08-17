package com.example.compmoviedb.di

import com.example.compmoviedb.domain.repository.MoviesRepository
import com.example.compmoviedb.domain.usecase.GetListActorsMovieByIdUseCase
import com.example.compmoviedb.domain.usecase.GetListMovieVideoByIdUseCase
import com.example.compmoviedb.domain.usecase.GetListMoviesPopularUseCase
import com.example.compmoviedb.domain.usecase.GetMovieDetailsByIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun providesGetListMoviesPopularUseCase(moviesRepository: MoviesRepository): GetListMoviesPopularUseCase =
        GetListMoviesPopularUseCase(moviesRepository = moviesRepository)

    @Provides
    @Singleton
    fun providesGetMovieDetailsByIdUseCase(moviesRepository: MoviesRepository): GetMovieDetailsByIdUseCase =
        GetMovieDetailsByIdUseCase(moviesRepository = moviesRepository)

    @Provides
    @Singleton
    fun providesGetListMovieVideoByIdUseCase(moviesRepository: MoviesRepository): GetListMovieVideoByIdUseCase =
        GetListMovieVideoByIdUseCase(moviesRepository = moviesRepository)

    @Provides
    @Singleton
    fun providesGetListActorsMovieByIdUseCase(moviesRepository: MoviesRepository): GetListActorsMovieByIdUseCase =
        GetListActorsMovieByIdUseCase(moviesRepository = moviesRepository)
}