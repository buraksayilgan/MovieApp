package com.mburaksayilgan.movieapp.ui.movieList.composables

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mburaksayilgan.movieapp.base.Composer
import com.mburaksayilgan.movieapp.ui.theme.MovieAppTheme
import com.mburaksayilgan.movieapp.viewModel.PopularMoviesViewModel

class MovieListComposer (
    private val viewModel: PopularMoviesViewModel
): Composer {

    @OptIn(ExperimentalLifecycleComposeApi::class)
    @Composable
    override fun Compose() {
        val movieList by viewModel.movieList.collectAsStateWithLifecycle()

        MovieAppTheme {
            MovieList(movieList) {
                viewModel.onClickMovie(it)
            }
        }
    }
}