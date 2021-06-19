package com.example.memestation.framework.datasource.network

import com.example.memestation.framework.datasource.network.model.MemeNetworkEntity

interface MemeRetrofitService {

    suspend fun get() : List<MemeNetworkEntity>

}