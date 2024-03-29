package com.example.memestation.framework.datasource.network

import android.util.Log
import com.example.memestation.framework.datasource.network.model.MemeNetworkEntity
import com.example.memestation.framework.datasource.network.retrofit.MemeRetrofit

class MemeRetrofitServiceImpl constructor(private val memeRetrofit : MemeRetrofit ) : MemeRetrofitService {

    override suspend fun get(): List<MemeNetworkEntity> {
        Log.d("ApiCheck", memeRetrofit.get().toString())
        return memeRetrofit.get().data.memes
    }


}