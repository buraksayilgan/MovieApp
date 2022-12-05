package com.mburaksayilgan.movieapp.data

import com.mburaksayilgan.movieapp.AppConfig
import com.mburaksayilgan.movieapp.data.networkModel.PopularMoviesNetworkModel
import com.mburaksayilgan.movieapp.data.networkModel.detail.MovieDetailNetworkModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query ("api_key") api_key: String,
//        @Query ("language") language: String,
//        @Query ("page") page: Int
    ) : PopularMoviesNetworkModel

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query ("api_key") api_key: String
    ) : MovieDetailNetworkModel
}