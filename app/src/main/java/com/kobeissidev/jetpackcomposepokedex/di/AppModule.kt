package com.kobeissidev.jetpackcomposepokedex.di

import android.app.Application
import android.content.Context
import coil.ImageLoader
import com.kobeissidev.jetpackcomposepokedex.data.local.PokeDatabase
import com.kobeissidev.jetpackcomposepokedex.data.remote.PokeApiService
import com.kobeissidev.jetpackcomposepokedex.data.repository.PokedexRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideImageLoader(@ApplicationContext context: Context) = ImageLoader.Builder(context).build()

    @Singleton
    @Provides
    fun providePokedexRepository(
        pokeApiService: PokeApiService,
        pokeDatabase: PokeDatabase,
        application: Application,
        imageLoader: ImageLoader
    ) = PokedexRepository(pokeApiService, pokeDatabase, application, imageLoader)
}