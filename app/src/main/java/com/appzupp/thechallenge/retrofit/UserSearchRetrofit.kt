package com.appzupp.thechallenge.retrofit

import io.reactivex.Observable
import retrofit2.http.GET

interface UserSearchRetrofit {
    @GET("/2.2/users?order=asc&sort=name&inname=SEARCH_VALUE &site=stackoverflow")
    fun getData() : Observable<List<UserListItemNetworkEntity>>
}