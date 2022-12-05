package com.mburaksayilgan.movieapp.di.movieList

import androidx.appcompat.app.AppCompatActivity
import com.mburaksayilgan.movieapp.ui.movieList.MovieListActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class MovieListActivityModule {

    @Provides
    @ActivityScoped
    fun provideActivity(activity: AppCompatActivity): MovieListActivity = activity as MovieListActivity


}