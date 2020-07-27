package com.appzupp.thechallenge.retrofit

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface UserSearchRetrofit {
    @GET("/2.2/users?order=asc&sort=name&inname={SEARCH_VALUE} &site=stackoverflow")
    suspend fun getData(@Path(value = "SEARCH_VALUE", encoded = false) key: String) : Observable<List<UserListItemNetworkEntity>>
}