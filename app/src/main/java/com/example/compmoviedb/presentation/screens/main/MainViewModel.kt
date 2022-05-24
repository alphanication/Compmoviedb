package com.example.compmoviedb.presentation.screens.main

import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compmoviedb.domain.models.MoviePopularDetails
import com.example.compmoviedb.domain.models.Response
import com.example.compmoviedb.domain.usecase.GetListMoviesPopularUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getListMoviesPopularUseCase: GetListMoviesPopularUseCase
) : ViewModel() {

    private val _loadingListMoviesPopular = MutableStateFlow<Boolean>(false)
    val loadingListMoviesPopular = _loadingListMoviesPopular.asStateFlow()

    private val _listMoviesPopular = MutableStateFlow<List<MoviePopularDetails>>(listOf())
    val listMoviesPopular = _listMoviesPopular.asStateFlow()

    fun getListMoviesPopular() {
        viewModelScope.launch(Dispatchers.IO) {
            getListMoviesPopularUseCase.execute().collect { result ->
                when (result) {
                    is Response.Loading -> _loadingListMoviesPopular.emit(true)
                    is Response.Fail -> {}
                    is Response.Success -> {
                        _loadingListMoviesPopular.emit(false)
                        _listMoviesPopular.emit(result.data.moviesPopularDetails)
                    }
                }
            }
        }
    }

}