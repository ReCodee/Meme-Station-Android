package com.example.memestation.bussiness.data.cache

import com.example.memestation.bussiness.domain.model.Meme

interface CacheDataSource {

    suspend fun insert(meme : Meme) : Long

    suspend fun insertList(memes : List<Meme>)

    suspend fun get() : List<Meme>
}