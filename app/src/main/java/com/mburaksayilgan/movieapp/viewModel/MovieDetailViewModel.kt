package com.mburaksayilgan.movieapp.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mburaksayilgan.movieapp.data.networkModel.detail.MovieDetailNetworkModel
import com.mburaksayilgan.movieapp.data.repository.MovieRepository
import com.mburaksayilgan.movieapp.utils.Status.ERROR
import com.mburaksayilgan.movieapp.utils.Status.SUCCESS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    var movieDetail = mutableStateOf<MovieDetailNetworkModel?>(null)

    fun loadMovieDetail(movieId: Int) {
        viewModelScope.launch {
            val result = repository.getMovieDetail(movieId)

            when (result.status) {
                SUCCESS -> {
                    val detail = result.data?.let {
                        MovieDetailNetworkModel(
                            it.adult,
                            it.backdrop_path,
                            it.belongs_to_collection,
                            it.id,
                            it.genres,
                            it.homepage,
                            it.id,
                            it.imdb_id,
                            it.original_language,
                            it.original_title,
                            it.overview,
                            it.popularity,
                            it.poster_path,
                            it.production_companies,
                            it.production_countries,
                            it.release_date,
                            it.revenue,
                            it.runtime,
                            it.spoken_languages,
                            it.status,
                            it.tagline,
                            it.original_title,
                            it.video,
                            it.vote_average,
                            it.vote_count,
                        )
                    }
                    movieDetail.value = detail
                }

                ERROR -> {

                }
            }
        }
    }
}
