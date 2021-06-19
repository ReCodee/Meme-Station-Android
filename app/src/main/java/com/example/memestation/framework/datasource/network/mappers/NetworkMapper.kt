package com.example.memestation.framework.datasource.network.mappers

import com.example.memestation.bussiness.domain.model.Meme
import com.example.memestation.bussiness.domain.utils.EntityMapper
import com.example.memestation.framework.datasource.network.model.MemeNetworkEntity

class NetworkMapper : EntityMapper<MemeNetworkEntity, Meme> {

    override fun mapFromEntity(entity: MemeNetworkEntity): Meme {
        return(
                Meme(entity.id,
                entity.name,
                entity.url,
                entity.width,
                entity.height,
                entity.box_count)
                )
    }

    override fun mapFromDomainModel(domainModel: Meme): MemeNetworkEntity {
        return(
                MemeNetworkEntity(
                    domainModel.id,
                    domainModel.name,
                    domainModel.url,
                    domainModel.width,
                    domainModel.height,
                    domainModel.box_count)
                )

    }

    fun mapFromEntityList(entities : List<MemeNetworkEntity>) : List<Meme> {
        return entities.map { mapFromEntity(it) }
    }

}