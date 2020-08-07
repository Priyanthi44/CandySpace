package com.appzupp.thechallenge.retrofit

import com.appzupp.thechallenge.model.UserListItem
import com.appzupp.thechallenge.util.NetworkEntityMapper
import javax.inject.Inject

class UserListItemNetworkMapper @Inject constructor() : NetworkEntityMapper<UserListItemNetworkEntity, UserListItem> {
    override fun mapFromEntity(entity: UserListItemNetworkEntity): UserListItem {
        return UserListItem(
            id =entity.id,
            username =entity.username,
            reputation =entity.reputation,
            picture =entity.picture,
            Location =entity.Location,
            Age =entity.Age,
            cdate =entity.cdate,
            badges = entity.badges
        )
    }


    override fun mapToEntity(domainModel: UserListItem): UserListItemNetworkEntity {
        return UserListItemNetworkEntity(
            id=domainModel.id,
            username=domainModel.username,
            reputation=domainModel.reputation,
            picture=domainModel.picture,
            Location=domainModel.Location,
            Age=domainModel.Age,
            cdate =domainModel.cdate,
            badges= domainModel.badges
        )
    }

    fun mapFromEntityList(entities: List<UserListItemNetworkEntity>):List<UserListItem>{
        return entities.map{mapFromEntity(it)}
    }
}