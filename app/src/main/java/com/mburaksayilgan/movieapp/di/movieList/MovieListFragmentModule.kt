package com.mburaksayilgan.movieapp.di.movieList

import androidx.fragment.app.Fragment
import com.mburaksayilgan.movieapp.base.Composer
import com.mburaksayilgan.movieapp.base.annotation.FragmentKey
import com.mburaksayilgan.movieapp.base.annotation.ScopedViewModel
import com.mburaksayilgan.movieapp.ui.movieList.MovieListFragment
import com.mburaksayilgan.movieapp.ui.movieList.composables.MovieListComposer
import com.mburaksayilgan.movieapp.viewModel.PopularMoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import dagger.multibindings.IntoMap


@Module
@InstallIn(FragmentComponent::class)
abstract class MovieFragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(MovieListFragment::class)
    abstract fun bindComposer(composer: MovieListComposer): Composer

}



@Module
@InstallIn(FragmentComponent::class)
class MovieFragmentProvidesModule {

    @Provides
    @FragmentScoped
    fun provideFragment(fragment: Fragment): MovieListFragment = fragment as MovieListFragment

    @Provides
    @FragmentScoped
    @ScopedViewModel
    fun provideScopedViewModel(fragment: MovieListFragment): PopularMoviesViewModel = fragment.viewModel

    @Provides
    @FragmentScoped
    fun provideComposer(
        @ScopedViewModel viewModel: PopularMoviesViewModel
    ) : MovieListComposer = MovieListComposer(viewModel)

//    @Provides
//    @FragmentScoped
//    fun provideNavigator(fragment: MovieListFragment): MovieListNavigator = MovieListNavigator(fragment)

}
