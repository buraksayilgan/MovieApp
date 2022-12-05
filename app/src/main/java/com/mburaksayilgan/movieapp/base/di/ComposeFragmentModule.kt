package com.mburaksayilgan.movieapp.base.di

import androidx.fragment.app.Fragment
import com.mburaksayilgan.movieapp.base.Composer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Provider


@Module
@InstallIn(FragmentComponent::class)
class ComposeFragmentModule {

    @Provides
    @FragmentScoped
    fun provideComposer(
       fragment: Fragment,
       mappedComposers: @JvmSuppressWildcards Map<Class<out Fragment>, Provider<Composer>>
    ): Composer = (mappedComposers[fragment::class.java]!!.get())
}