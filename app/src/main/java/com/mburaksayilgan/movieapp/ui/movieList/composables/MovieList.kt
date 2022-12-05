package com.mburaksayilgan.movieapp.ui.movieList.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mburaksayilgan.movieapp.AppConfig
import com.mburaksayilgan.movieapp.data.networkModel.PopularMoviesResultNetworkModel

@Composable
fun MovieList(
    movieList: List<PopularMoviesResultNetworkModel>,
    onClickMovie: (movieId: Int) -> Unit
) {
    MovieGridView(movies = movieList, onClickMovie)
}

@Composable
fun MovieGridView(movies: List<PopularMoviesResultNetworkModel>, onClickMovie: (movieId: Int) -> Unit) {
    LazyVerticalGrid(
        horizontalArrangement = Arrangement.Center,
        contentPadding = PaddingValues(4.dp),
        columns = GridCells.Fixed(2)) {

        items(movies) { movie ->
            MovieRow(movie = movie, onClickMovie)
        }
    }
}

@Composable
fun MovieRow(movie: PopularMoviesResultNetworkModel, onClickMovie: (movieId: Int) -> Unit) {
    Box(modifier = Modifier.border(1.dp, color = Color.Gray).clip(RoundedCornerShape(5.dp)), contentAlignment = Alignment.Center) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.clickable { onClickMovie(movie.id!!) }
        ) {

            AsyncImage(
                model = AppConfig.IMAGE_BASE_URL +movie.poster_path,
                contentDescription = null,
                alignment = Alignment.CenterStart)

            Spacer(modifier = Modifier.padding(4.dp))

            Text(text = movie.title, textAlign = TextAlign.Center)
        }
    }
}