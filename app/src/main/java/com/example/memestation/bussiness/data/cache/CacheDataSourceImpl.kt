package com.example.memestation.bussiness.data.cache

import com.example.memestation.bussiness.domain.model.Meme
import com.example.memestation.framework.datasource.cache.MemeDaoService
import com.example.memestation.framework.datasource.cache.mapper.CacheMapper

class CacheDataSourceImpl
    constructor(private val memeDaoService: MemeDaoService, private val cacheMapper: CacheMapper)
    : CacheDataSource {

    override suspend fun insert(meme: Meme): Long {
      return memeDaoService.insert(cacheMapper.mapFromDomainModel(meme))
    }

    override suspend fun insertList(memes : List<Meme>) {
        for ( meme in memes ) {
            insert(meme)
        }
    }

    override suspend fun get(): List<Meme> {
        return cacheMapper.mapFromEntityList(memeDaoService.get())
    }
}