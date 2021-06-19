package com.example.memestation.bussiness.data.network

import com.example.memestation.bussiness.domain.model.Meme

interface NetworkDataSource {

    suspend fun get() : List<Meme>

}