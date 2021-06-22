package com.example.memestation.framework.datasource.cache

import com.example.memestation.framework.datasource.cache.model.MemeCacheEntity

interface MemeDaoService {

    suspend fun insert(memeCacheEntity: MemeCacheEntity) : Long

    suspend fun get() : List<MemeCacheEntity>

}