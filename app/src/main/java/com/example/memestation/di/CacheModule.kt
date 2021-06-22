package com.example.memestation.di

import android.content.Context
import androidx.room.Room
import com.example.memestation.bussiness.data.cache.CacheDataSource
import com.example.memestation.bussiness.data.cache.CacheDataSourceImpl
import com.example.memestation.framework.datasource.cache.Database.MemeDao
import com.example.memestation.framework.datasource.cache.Database.MemeDatabase
import com.example.memestation.framework.datasource.cache.MemeDaoService
import com.example.memestation.framework.datasource.cache.MemeDaoServiceImpl
import com.example.memestation.framework.datasource.cache.mapper.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Provides
    @Singleton
    fun provideCacheMapper() : CacheMapper {
        return CacheMapper()
    }

    @Provides
    @Singleton
    fun provideMemeDb(@ApplicationContext context : Context) : MemeDatabase {
        return Room
               .databaseBuilder(context,
               MemeDatabase::class.java,
               MemeDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideMemeDao(memeDatabase: MemeDatabase) : MemeDao {
        return memeDatabase.memeDao()
    }

    @Provides
    @Singleton
    fun provideMemeDaoService(memeDao : MemeDao) : MemeDaoService {
        return MemeDaoServiceImpl(memeDao)
    }

    @Provides
    @Singleton
    fun provideCacheDataSource(cacheMapper: CacheMapper, memeDaoService: MemeDaoService) : CacheDataSource {
        return CacheDataSourceImpl(memeDaoService, cacheMapper)
    }

}