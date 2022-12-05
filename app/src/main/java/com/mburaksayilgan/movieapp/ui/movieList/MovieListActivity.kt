package com.mburaksayilgan.movieapp.ui.movieList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.mburaksayilgan.movieapp.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieListActivity : AppCompatActivity(R.layout.activity_base) {

    private val navController get() = (supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment).navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navController.setGraph(R.navigation.nav_graph)
    }

}
