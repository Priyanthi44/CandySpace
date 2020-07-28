package com.appzupp.thechallenge.repository

import com.appzupp.thechallenge.model.User
import com.appzupp.thechallenge.model.UserListItem
import com.appzupp.thechallenge.retrofit.LoadUsersRetrofit
import com.appzupp.thechallenge.retrofit.UserListItemNetworkMapper
import com.appzupp.thechallenge.retrofit.UserNetworkMapper
import com.appzupp.thechallenge.retrofit.UserSearchRetrofit
import com.appzupp.thechallenge.util.NetworkState
import io.reactivex.Maybe
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository
constructor(
private val userlist:UserSearchRetrofit,
private val userlistMapper:UserListItemNetworkMapper)

{
/*TODO()
*call maybe rxjava for observables
* network state to loading to show progrss bar
* need to cache data only for the list for the back button
* add query to a set with hashmap so that same requests are not frequently downloaded
* SQL lite database is not used as these queries do not need to be persisted
* Just aiming for providing a good user interaction
* */
suspend fun getUserList(searchQ:String):Flow<NetworkState<List<UserListItem>>> =flow{
emit(NetworkState.Loading)
    try{
        val netuserlist=userlist.getData(searchQ)
        val userList=userlistMapper.mapFromEntityList(netuserlist)
        emit(NetworkState.Success(userList))
    }catch(e:Exception){
        emit(NetworkState.Error(e))
    }
}

}