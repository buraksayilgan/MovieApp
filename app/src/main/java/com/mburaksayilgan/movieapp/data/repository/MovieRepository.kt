package com.mburaksayilgan.movieapp.data.repository

import com.mburaksayilgan.movieapp.AppConfig.API_KEY
import com.mburaksayilgan.movieapp.data.Api
import com.mburaksayilgan.movieapp.data.networkModel.PopularMoviesNetworkModel
import com.mburaksayilgan.movieapp.data.networkModel.detail.MovieDetailNetworkModel
import com.mburaksayilgan.movieapp.data.repository.`interface`.MovieRepositoryInterface
import com.mburaksayilgan.movieapp.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

class MovieRepository @Inject constructor(private val api: Api) {

    suspend fun getPopularMovies(): Resource<PopularMoviesNetworkModel> {
        val response = try {
            api.getPopularMovies(
                API_KEY
            )
        } catch (e: Exception) {
            return Resource.error(msg = "Error", data = null)
        }
        return Resource.success(data = response)
    }

    suspend fun getMovieDetail(movieId: Int): Resource<MovieDetailNetworkModel> {
        val response = try {
            api.getMovieDetail(
                movieId, API_KEY
            )
        } catch (e: Exception) {
            return Resource.error(msg = "Error", data = null)
        }
        return Resource.success(data = response)
    }
}
