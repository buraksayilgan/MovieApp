package com.mburaksayilgan.movieapp.di

import android.content.Context
import androidx.room.Room
import com.mburaksayilgan.movieapp.AppConfig.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

//    @Singleton
//    @Provides
//    fun createDatabase(@ApplicationContext context: Context): MovieAppDatabase {
//        return Room.databaseBuilder(
//            context.applicationContext,
//            MovieAppDatabase::class.java,
//            DB_NAME
//        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
//    }
}