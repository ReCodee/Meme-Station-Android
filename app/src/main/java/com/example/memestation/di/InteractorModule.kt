package com.example.memestation.di

import com.example.memestation.bussiness.data.network.NetworkDataSource
import com.example.memestation.bussiness.interactors.MemeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorModule {

@Provides
@Singleton
fun provideMemeRepository(networkDataSource: NetworkDataSource) : MemeRepository {
    return MemeRepository(networkDataSource)
}

}