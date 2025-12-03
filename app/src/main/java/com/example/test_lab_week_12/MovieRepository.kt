package com.example.test_lab_week_12

import com.example.test_lab_week_12.api.MovieService
import com.example.test_lab_week_12.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepository(private val movieService: MovieService) {

    private val apiKey = "be29b2d33e2cb83e63b3e355be495fce"

    // Flow to emit movie list
    fun getPopularMoviesFlow(): Flow<List<Movie>> = flow {
        val response = movieService.getPopularMovies(apiKey)
        emit(response.results)
    }

    // Flow to emit errors
    fun getErrorFlow(): Flow<String> = flow {
        try {
            movieService.getPopularMovies(apiKey)
            emit("")
        } catch (e: Exception) {
            emit("An error occurred: ${e.message}")
        }
    }
}
