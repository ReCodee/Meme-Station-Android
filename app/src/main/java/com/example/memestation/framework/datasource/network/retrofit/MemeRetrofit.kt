package com.example.memestation.framework.datasource.network.retrofit

import com.example.memestation.bussiness.domain.model.RawData
import com.example.memestation.framework.datasource.network.model.MemeNetworkEntity
import retrofit2.http.GET

interface MemeRetrofit {

    @GET("get_memes")
    suspend fun get() : RawData

}