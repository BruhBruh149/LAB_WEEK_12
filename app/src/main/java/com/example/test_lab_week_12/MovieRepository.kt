package com.example.test_lab_week_12

import com.example.test_lab_week_12.api.MovieService
import com.example.test_lab_week_12.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepository(private val movieService: MovieService) {

    private val apiKey = "be29b2d33e2cb83e63b3e355be495fce"
    fun getFilteredMovies(year: String): Flow<List<Movie>> = flow {
        try {
            val response = movieService.getPopularMovies(apiKey)

            val filtered = response.results
                .filter { it.releaseDate?.startsWith(year) == true }
                .sortedByDescending { it.popularity }

            emit(filtered)

        } catch (e: Exception) {
            // If error, emit empty list (ViewModel will emit error separately)
            emit(emptyList())
        }
    }

    // Flow for error handling
    fun getErrorFlow(): Flow<String> = flow {
        try {
            movieService.getPopularMovies(apiKey)
            emit("")
        } catch (e: Exception) {
            emit("Error: ${e.message}")
        }
    }
}
