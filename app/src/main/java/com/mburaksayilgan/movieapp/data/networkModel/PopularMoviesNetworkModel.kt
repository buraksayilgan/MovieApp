package com.mburaksayilgan.movieapp.data.networkModel

data class PopularMoviesNetworkModel(
    val page: Int,
    val results: List<PopularMoviesResultNetworkModel>,
    val total_pages: Int,
    val total_results: Int
)