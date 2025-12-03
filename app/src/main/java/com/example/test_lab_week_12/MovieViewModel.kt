package com.example.test_lab_week_12

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.test_lab_week_12.model.Movie

class MovieViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    val popularMovies = repository
        .getPopularMoviesFlow()
        .asLiveData()

    val error = repository
        .getErrorFlow()
        .asLiveData()
}
