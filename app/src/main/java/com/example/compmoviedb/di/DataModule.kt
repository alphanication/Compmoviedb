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
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataModule {
    @Provides
    fun baseUrl() = "https://api.themoviedb.org/"

    @Provides
    @Singleton
    fun provideRetrofit(): MovieDBApiInterface =
        Retrofit.Builder()
            .baseUrl(baseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieDBApiInterface::class.java)

    @Provides
    @Singleton
    fun providesMoviesStorage(movieDBApiInterface: MovieDBApiInterface): MoviesStorage {
        return TheMovieDBMoviesStorageImpl(movieDBApiInterface = movieDBApiInterface)
    }

    @Provides
    @Singleton
    fun providesMoviesRepository(moviesStorage: MoviesStorage): MoviesRepository {
        return MoviesRepositoryImpl(moviesStorage = moviesStorage)
    }
}