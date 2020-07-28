package com.appzupp.thechallenge.room

import com.appzupp.thechallenge.model.UserListItem
import com.appzupp.thechallenge.retrofit.UserListItemNetworkEntity
import com.appzupp.thechallenge.util.NetworkEntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor():NetworkEntityMapper<UserListCacheEntity, UserListItem>{
    override fun mapFromEntity(entity: UserListCacheEntity): UserListItem {
        return UserListItem(
            id=entity.id,
            username=entity.username,
            reputation=entity.reputation
        )
    }

    override fun mapToEntity(domainModel: UserListItem): UserListCacheEntity {
        return UserListCacheEntity(
            id=domainModel.id,
            username=domainModel.username,
            reputation=domainModel.reputation
        )
    }
    fun mapFromEntityList(entities: List<UserListCacheEntity>):List<UserListItem>{
        return entities.map{mapFromEntity(it)}
    }
}