package com.mburaksayilgan.movieapp.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mburaksayilgan.movieapp.data.networkModel.PopularMoviesResultNetworkModel
import com.mburaksayilgan.movieapp.data.repository.MovieRepository
import com.mburaksayilgan.movieapp.utils.Status.ERROR
import com.mburaksayilgan.movieapp.utils.Status.SUCCESS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val repository: MovieRepository,
//    private val navigator: MovieListNavigator
) : ViewModel() {

//    var movieList = mutableStateOf<List<PopularMoviesResultNetworkModel>>(listOf())
    var errorMessage = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    private val movieListFlow = MutableStateFlow<List<PopularMoviesResultNetworkModel>>(emptyList())
    val movieList = movieListFlow.asStateFlow()

    init {
        loadMovies()
    }

    fun loadMovies() {
        viewModelScope.launch {
            isLoading.value = true
            val result = repository.getPopularMovies()

            when (result.status) {
                SUCCESS -> {
                    val movies = result.data!!.results.mapIndexed { index, item ->
                        PopularMoviesResultNetworkModel(
                            item.adult,
                            item.backdrop_path,
                            item.genre_ids,
                            item.id,
                            item.original_language,
                            item.original_title,
                            item.overview,
                            item.popularity,
                            item.poster_path,
                            item.release_date,
                            item.title,
                            item.video,
                            item.vote_average,
                            item.vote_count
                        )
                    }

                    movieListFlow.value += movies
                    isLoading.value = false
                }

                ERROR -> {
                    errorMessage.value = result.message!!
                    isLoading.value = false
                }
            }
        }
    }

    fun onClickMovie(movieId: Int) {
//        navigator.navigateToDetails(movieId)
    }
}