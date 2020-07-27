package com.appzupp.thechallenge.repository

import com.appzupp.thechallenge.model.UserListItem
import com.appzupp.thechallenge.retrofit.LoadUsersRetrofit
import com.appzupp.thechallenge.retrofit.UserListItemNetworkMapper
import com.appzupp.thechallenge.retrofit.UserNetworkMapper
import com.appzupp.thechallenge.retrofit.UserSearchRetrofit
import com.appzupp.thechallenge.util.NetworkState

class MainRepository
constructor(private val user:LoadUsersRetrofit,
private val userlist:UserSearchRetrofit,
private val userMapper:UserNetworkMapper,
private val userlistMapper:UserListItemNetworkMapper)

{

}