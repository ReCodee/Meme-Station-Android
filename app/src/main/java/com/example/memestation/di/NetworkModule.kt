package com.example.memestation.di

import com.example.memestation.bussiness.data.network.NetworkDataSource
import com.example.memestation.bussiness.data.network.NetworkDataSourceImpl
import com.example.memestation.bussiness.domain.model.Meme
import com.example.memestation.bussiness.domain.utils.EntityMapper
import com.example.memestation.framework.datasource.network.MemeRetrofitService
import com.example.memestation.framework.datasource.network.MemeRetrofitServiceImpl
import com.example.memestation.framework.datasource.network.mappers.NetworkMapper
import com.example.memestation.framework.datasource.network.model.MemeNetworkEntity
import com.example.memestation.framework.datasource.network.retrofit.MemeRetrofit
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

@Provides
@Singleton
fun provideNetworkMapper() : EntityMapper<MemeNetworkEntity, Meme> {
    return NetworkMapper()
}

@Provides
@Singleton
fun provideGsonBuilder() : Gson {
    return GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create()
}

@Provides
@Singleton
fun provideRetrofit(gson : Gson) : Retrofit.Builder {
    return Retrofit.Builder()
        .baseUrl(" https://api.imgflip.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
}

@Provides
@Singleton
fun provideMemeService(retrofit : Retrofit.Builder) : MemeRetrofit {
    return retrofit
        .build()
        .create(MemeRetrofit::class.java)
}

@Provides
@Singleton
fun provideRetrofitService(memeRetrofit : MemeRetrofit) : MemeRetrofitService {
    return MemeRetrofitServiceImpl(memeRetrofit)
}

@Provides
@Singleton
fun provideNetworkDataSource(
    memeRetrofitService : MemeRetrofitService,
    networkMapper: NetworkMapper
) : NetworkDataSource {
    return NetworkDataSourceImpl(memeRetrofitService, networkMapper)
}


}