package com.example.test_lab_week_12

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    fun getMoviesForYear(year: String) =
        repository.getFilteredMovies(year).asLiveData()

    // Error flow
    val error = repository.getErrorFlow().asLiveData()
}
