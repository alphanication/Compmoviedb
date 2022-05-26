package com.example.compmoviedb.presentation.screens.detailsmovie

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compmoviedb.domain.models.Response
import com.example.compmoviedb.domain.models.moviedetails.MovieDetailsD
import com.example.compmoviedb.domain.usecase.GetMovieDetailsByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsMovieViewModel @Inject constructor(
    private val getMovieDetailsByIdUseCase: GetMovieDetailsByIdUseCase
) : ViewModel() {

    fun getMovieDetailsById(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            getMovieDetailsByIdUseCase.execute(movieId = movieId).collect { response ->
                when(response) {
                    is Response.Loading -> {}
                    is Response.Fail -> {}
                    is Response.Success -> Log.d("alpha33", response.data.title)
                }
            }
        }
    }
}