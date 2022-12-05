package com.mburaksayilgan.movieapp.ui.movieList

import androidx.fragment.app.viewModels
import com.mburaksayilgan.movieapp.base.ComposeBaseFragment
import com.mburaksayilgan.movieapp.viewModel.PopularMoviesViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieListFragment: ComposeBaseFragment() {

    val viewModel by viewModels<PopularMoviesViewModel>()
}