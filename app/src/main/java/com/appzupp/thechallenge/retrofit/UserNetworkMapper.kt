package com.appzupp.thechallenge.retrofit

import com.appzupp.thechallenge.model.Badges
import com.appzupp.thechallenge.model.User
import com.appzupp.thechallenge.util.NetworkEntityMapper
import java.sql.Date
import javax.inject.Inject

class UserNetworkMapper @Inject constructor() : NetworkEntityMapper<UserNetworkEntity, User> {
    override fun mapFromEntity(entity: UserNetworkEntity): User {
        return User(
            id=entity.id,
       username=entity.username,
        reputation=entity.reputation,
        picture=entity.picture,
       Location=entity.Location,
        Age=entity.Age,
        cdate =entity.cdate,
        badges= entity.badges
        )
    }

    override fun mapToEntity(domainModel: User): UserNetworkEntity {
        return UserNetworkEntity(
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

}