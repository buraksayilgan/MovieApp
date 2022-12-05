package com.mburaksayilgan.movieapp.di

import android.view.View
import com.mburaksayilgan.movieapp.utils.NavigationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideContext(@ApplicationContext context: ApplicationContext) : ApplicationContext = context

//    @Singleton
//    @Provides
//    fun provideNavigationManager(view: View): NavigationManager = NavigationManager(view)
}