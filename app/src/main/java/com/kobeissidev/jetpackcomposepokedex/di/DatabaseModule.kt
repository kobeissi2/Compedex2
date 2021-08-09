package com.kobeissidev.jetpackcomposepokedex.di

import android.content.Context
import androidx.room.Room
import com.kobeissidev.jetpackcomposepokedex.data.local.PokeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context) = Room.databaseBuilder(
        appContext,
        PokeDatabase::class.java,
        PokeDatabase::class.java.simpleName
    ).fallbackToDestructiveMigration().build()
}