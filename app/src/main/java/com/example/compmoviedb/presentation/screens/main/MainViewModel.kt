package com.example.compmoviedb.presentation.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compmoviedb.domain.models.MoviePopularDetails
import com.example.compmoviedb.domain.models.Response
import com.example.compmoviedb.domain.usecase.GetListMoviesPopularUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getListMoviesPopularUseCase: GetListMoviesPopularUseCase
) : ViewModel() {

    private val _loadingListMoviesPopular = MutableLiveData<Boolean>()
    val loadingListMoviesPopular: LiveData<Boolean> = _loadingListMoviesPopular

    private val _listMoviesPopular = MutableLiveData<List<MoviePopularDetails>>()
    val listMoviesPopular: LiveData<List<MoviePopularDetails>> = _listMoviesPopular

    fun getListMoviesPopular() {
        viewModelScope.launch(Dispatchers.IO) {
            getListMoviesPopularUseCase.execute().collect { result ->
                when (result) {
                    is Response.Loading -> _loadingListMoviesPopular.postValue(true)
                    is Response.Fail -> {}
                    is Response.Success -> {
                        _loadingListMoviesPopular.postValue(false)
                        _listMoviesPopular.postValue(result.data.moviesPopularDetails)
                    }
                }
            }
        }
    }

}