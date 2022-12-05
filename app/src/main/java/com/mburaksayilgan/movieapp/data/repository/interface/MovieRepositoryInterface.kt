package com.mburaksayilgan.movieapp.data.repository.`interface`

import com.mburaksayilgan.movieapp.data.networkModel.PopularMoviesNetworkModel
import com.mburaksayilgan.movieapp.data.networkModel.detail.MovieDetailNetworkModel
import com.mburaksayilgan.movieapp.utils.Resource

interface MovieRepositoryInterface {

    suspend fun getPopularMovies(): Resource<PopularMoviesNetworkModel>

    suspend fun getMovieDetail(movieId: Int): Resource<MovieDetailNetworkModel>
}