package com.example.memestation.bussiness.data.network

import com.example.memestation.bussiness.domain.model.Meme
import com.example.memestation.framework.datasource.network.MemeRetrofitService
import com.example.memestation.framework.datasource.network.mappers.NetworkMapper

class NetworkDataSourceImpl constructor(private val memeRetrofitService : MemeRetrofitService, private val networkMapper : NetworkMapper) : NetworkDataSource {

    override suspend fun get(): List<Meme> {
        return networkMapper.mapFromEntityList(memeRetrofitService.get())
    }

}