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

@Module
@InstallIn(SingletonComponent::class)
object NetworkCommonModule {

    @Provides
    @Singleton
    fun provideRetrofit(): MovieDBApiInterface =
        Retrofit.Builder()
            .baseUrl(MovieDBApiInterface.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieDBApiInterface::class.java)
}