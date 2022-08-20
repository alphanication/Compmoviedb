package com.example.compmoviedb.di

import com.example.compmoviedb.data.repository.MoviesRepositoryImpl
import com.example.compmoviedb.data.dataSource.MoviesDataSource
import com.example.compmoviedb.data.dataSource.themoviedb.MovieDBApiInterface
import com.example.compmoviedb.data.dataSource.themoviedb.TheMovieDBMoviesDataSource
import com.example.compmoviedb.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesMoviesStorage(movieDBApiInterface: MovieDBApiInterface): MoviesDataSource =
        TheMovieDBMoviesDataSource(movieDBApiInterface = movieDBApiInterface)

    @Provides
    @Singleton
    fun providesMoviesRepository(moviesStorage: MoviesDataSource): MoviesRepository =
        MoviesRepositoryImpl(moviesStorage = moviesStorage)
}