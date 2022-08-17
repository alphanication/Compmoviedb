package com.example.compmoviedb.di

import com.example.compmoviedb.data.repository.MoviesRepositoryImpl
import com.example.compmoviedb.data.storage.MoviesStorage
import com.example.compmoviedb.data.storage.themoviedb.MovieDBApiInterface
import com.example.compmoviedb.data.storage.themoviedb.TheMovieDBMoviesStorageImpl
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
    fun providesMoviesStorage(movieDBApiInterface: MovieDBApiInterface): MoviesStorage =
        TheMovieDBMoviesStorageImpl(movieDBApiInterface = movieDBApiInterface)

    @Provides
    @Singleton
    fun providesMoviesRepository(moviesStorage: MoviesStorage): MoviesRepository =
        MoviesRepositoryImpl(moviesStorage = moviesStorage)
}