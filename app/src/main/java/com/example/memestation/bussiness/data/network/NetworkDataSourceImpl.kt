package com.example.memestation.bussiness.data.network

import android.util.Log
import com.example.memestation.bussiness.domain.model.Meme
import com.example.memestation.framework.datasource.network.MemeRetrofitService
import com.example.memestation.framework.datasource.network.mappers.NetworkMapper
import javax.inject.Inject

class NetworkDataSourceImpl
@Inject
constructor(private val memeRetrofitService : MemeRetrofitService, private val networkMapper : NetworkMapper) : NetworkDataSource {

    override suspend fun get(): List<Meme> {
       // Log.d("BugCheck", memeRetrofitService.get().toString())
        return networkMapper.mapFromEntityList(memeRetrofitService.get())
    }

}