package com.example.memestation.bussiness.domain.utils

interface EntityMapper<Entity, DomainModel> {

    fun mapFromEntity(entity: Entity) : DomainModel

    fun mapFromDomainModel(domainModel: DomainModel) : Entity

}