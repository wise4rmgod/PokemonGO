package com.dev.pokemongo.di

import android.content.Context
import androidx.room.Room
import com.dev.pokemongo.db.AppDatabase
import com.dev.pokemongo.db.PokemonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java, "ovmedia.db"
        )
            .build()
    }

    @Provides
    fun provideLogDao(database: AppDatabase): PokemonDao {
        return database.pokemon()
    }
}