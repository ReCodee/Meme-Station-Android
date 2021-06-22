package com.example.memestation.framework.datasource.cache

import com.example.memestation.framework.datasource.cache.Database.MemeDao
import com.example.memestation.framework.datasource.cache.model.MemeCacheEntity

class MemeDaoServiceImpl
    constructor(private val memeDao: MemeDao)
    : MemeDaoService {
    override suspend fun insert(memeCacheEntity: MemeCacheEntity): Long {
        return memeDao.insert(memeCacheEntity)
    }

    override suspend fun get(): List<MemeCacheEntity> {
        return memeDao.get()
    }
}