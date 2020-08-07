package com.appzupp.thechallenge.util

interface NetworkEntityMapper <Entity,DomainModel> {
    fun mapFromEntity(entity: Entity): DomainModel
    fun mapToEntity(domainModel: DomainModel):Entity
}