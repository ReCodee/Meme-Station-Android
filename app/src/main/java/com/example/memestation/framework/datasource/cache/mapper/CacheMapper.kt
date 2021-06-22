package com.example.memestation.framework.datasource.cache.mapper

import com.example.memestation.bussiness.domain.model.Meme
import com.example.memestation.bussiness.domain.utils.EntityMapper
import com.example.memestation.framework.datasource.cache.model.MemeCacheEntity
import com.example.memestation.framework.datasource.network.model.MemeNetworkEntity

class CacheMapper : EntityMapper<MemeCacheEntity, Meme> {

    override fun mapFromEntity(entity: MemeCacheEntity): Meme {
        return(
                Meme(entity.id,
                    entity.name,
                    entity.url,
                    entity.width,
                    entity.height,
                    entity.box_count)
                )
    }

    override fun mapFromDomainModel(domainModel: Meme): MemeCacheEntity {
          return(
                  MemeCacheEntity(
                      domainModel.id,
                      domainModel.name,
                      domainModel.url,
                      domainModel.width,
                      domainModel.height,
                      domainModel.box_count
                  )
                  )
    }

    fun mapFromEntityList(entities : List<MemeCacheEntity>) : List<Meme> {
        return entities.map { mapFromEntity(it) }
    }

}